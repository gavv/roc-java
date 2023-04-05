/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_rocstreaming_roctoolkit_Receiver */

#ifndef _Included_org_rocstreaming_roctoolkit_Receiver
#define _Included_org_rocstreaming_roctoolkit_Receiver
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_rocstreaming_roctoolkit_Receiver
 * Method:    open
 * Signature: (JLorg/rocstreaming/roctoolkit/ReceiverConfig;)J
 */
JNIEXPORT jlong JNICALL Java_org_rocstreaming_roctoolkit_Receiver_open
  (JNIEnv *, jclass, jlong, jobject);

/*
 * Class:     org_rocstreaming_roctoolkit_Receiver
 * Method:    setMulticastGroup
 * Signature: (JIILjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_org_rocstreaming_roctoolkit_Receiver_setMulticastGroup
  (JNIEnv *, jobject, jlong, jint, jint, jstring);

/*
 * Class:     org_rocstreaming_roctoolkit_Receiver
 * Method:    bind
 * Signature: (JIILorg/rocstreaming/roctoolkit/Endpoint;)V
 */
JNIEXPORT void JNICALL Java_org_rocstreaming_roctoolkit_Receiver_bind
  (JNIEnv *, jobject, jlong, jint, jint, jobject);

/*
 * Class:     org_rocstreaming_roctoolkit_Receiver
 * Method:    readFloats
 * Signature: (J[F)V
 */
JNIEXPORT void JNICALL Java_org_rocstreaming_roctoolkit_Receiver_readFloats
  (JNIEnv *, jobject, jlong, jfloatArray);

/*
 * Class:     org_rocstreaming_roctoolkit_Receiver
 * Method:    close
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_rocstreaming_roctoolkit_Receiver_close
  (JNIEnv *, jclass, jlong);

#ifdef __cplusplus
}
#endif
#endif