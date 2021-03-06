#include "org_rocstreaming_roctoolkit_Context.h"
#include "common.h"

#include <roc/context.h>

#define CONTEXT_CLASS               PACKAGE_BASE_NAME "/Context"
#define CONTEXT_CONFIG_CLASS        PACKAGE_BASE_NAME "/ContextConfig"

char context_config_unmarshall(JNIEnv *env, roc_context_config* conf, jobject jconfig) {
    jclass contextConfigClass;
    char err = 0;

    contextConfigClass = env->FindClass(CONTEXT_CONFIG_CLASS);
    assert(contextConfigClass != NULL);

    memset(conf, 0, sizeof(roc_context_config));

    conf->max_packet_size = get_uint_field_value(env, contextConfigClass, jconfig, "maxPacketSize", &err);
    if (err) return err;
    conf->max_frame_size = get_uint_field_value(env, contextConfigClass, jconfig, "maxFrameSize", &err);
    return err;
}

JNIEXPORT void JNICALL Java_org_rocstreaming_roctoolkit_Context_open(JNIEnv *env, jobject thisObj, jobject config) {
    roc_context*        context;
    roc_context_config  context_config;
    jclass              contextClass;

    if (config == NULL) {
        jclass exceptionClass = env->FindClass(ILLEGAL_ARGUMENTS_EXCEPTION);
        env->ThrowNew(exceptionClass, "Wrong context configuration values");
        return;
    }

    contextClass = env->FindClass(CONTEXT_CLASS);
    assert(contextClass != NULL);

    if (context_config_unmarshall(env, &context_config, config) != 0) {
        jclass exceptionClass = env->FindClass(ILLEGAL_ARGUMENTS_EXCEPTION);
        env->ThrowNew(exceptionClass, "Wrong context configuration values");
        return;
    }

    if ((context = roc_context_open(&context_config)) == NULL) {
        jclass exceptionClass = env->FindClass(EXCEPTION);
        env->ThrowNew(exceptionClass, "Error opening context");
        return;
    }

    set_native_pointer(env, contextClass, thisObj, context);
}

JNIEXPORT void JNICALL Java_org_rocstreaming_roctoolkit_Context_close(JNIEnv *env, jobject thisObj, jlong nativePtr) {

    roc_context* context = (roc_context*) nativePtr;

    if (roc_context_close(context) != 0) {
        jclass exceptionClass = env->FindClass(EXCEPTION);
        env->ThrowNew(exceptionClass, "Error closing context");
    }
}
