#include "channel_layout.h"
#include "common.h"

#include <roc/config.h>

roc_channel_layout get_channel_layout(JNIEnv* env, jobject jchannel_layout) {
    jclass channelLayoutClass = NULL;

    channelLayoutClass = (*env)->FindClass(env, CHANNEL_LAYOUT_CLASS);
    assert(channelLayoutClass != NULL);

    return (roc_channel_layout) get_enum_value(env, channelLayoutClass, jchannel_layout);
}
