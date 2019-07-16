/* Created by Keltika.
 * Copyright (c) 2018 Regions (exc sp. z.o.o.). All rights reserved.
 * NOTICE:  All information contained herein is, and remains
 * the property of exc sp. z.o.o. and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to exc sp. z.o.o.
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from exc sp. z.o.o.
 */
package com.regionsoverlay.ui;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.bridge.JavaScriptModule;
public class RNRegionsOverlayPackage implements ReactPackage {
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return Arrays.<NativeModule>asList(new RNRegionsOverlayModule(reactContext));
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList(new RegionsOverlayManager(reactContext));
    }
}