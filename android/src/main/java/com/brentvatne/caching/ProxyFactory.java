package com.brentvatne.caching;

import android.content.Context;

import com.danikula.videocache.HttpProxyCacheServer;

public class ProxyFactory {

    private static HttpProxyCacheServer sharedProxy;

    private ProxyFactory() {
    }

    public static HttpProxyCacheServer getProxy(Context context) {
        return sharedProxy == null ? (sharedProxy = newProxy(context)) : sharedProxy;
    }

    private static HttpProxyCacheServer newProxy(Context context) {
        return new HttpProxyCacheServer.Builder(context)
                .maxCacheSize(150 * 1024 * 1024)       // 150 mb cache limit
                .build();
    }
}