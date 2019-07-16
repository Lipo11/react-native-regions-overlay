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

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

import javax.annotation.Nullable;

@ReactModule(name = RegionsOverlayManager.REACT_CLASS)
public class RegionsOverlayManager extends ViewGroupManager<RegionsOverlayView> {

  protected static final String REACT_CLASS = "RNTRegionsOverlay";
  private final @Nullable Object mCallerContext;

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  public RegionsOverlayManager(Object callerContext) {
    mCallerContext = callerContext;
  }

  public RegionsOverlayManager() {
    mCallerContext = null;
  }

  @Override
  public RegionsOverlayView createViewInstance(ThemedReactContext context) {
    return new RegionsOverlayView(context);
  }

  @ReactProp(name = "regions")
  public void setTimeout(RegionsOverlayView view, ReadableArray regions) {
    view.setRegions( regions );
  }
}