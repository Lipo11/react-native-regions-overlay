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

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

public class RegionsOverlayView extends ViewGroup
{
	private ReadableArray regions = null;

	private Xfermode normalMode = null;
	private Xfermode clearMode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

	private Paint overlayPaint;

	private int overlayColor = Color.argb(200, 0, 0 ,0);

	private float scale;
	private RectF rect = new RectF();

	public RegionsOverlayView(Context context)
	{
		super(context);

		DisplayMetrics dm = getResources().getDisplayMetrics() ;
		scale = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, dm);

		setLayerType(View.LAYER_TYPE_SOFTWARE, null);

		overlayPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		overlayPaint.setColor(overlayColor);
		overlayPaint.setStyle(Paint.Style.FILL);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// draw overlay bg
		overlayPaint.setXfermode(normalMode);
    	canvas.drawPaint(overlayPaint);

    	// draw overlay regions
    	if( regions != null && regions.size() > 0 ) {

			overlayPaint.setXfermode(clearMode);

			for(int i=0; i<regions.size(); i++){
				ReadableMap region = regions.getMap(i);

				String type = region.hasKey("type") ? region.getString("type") : "undefined_type";
				ReadableMap position = region.hasKey("position") ? region.getMap("position") : null;

				switch(type){
					case "circle":
						if(position.hasKey("radius")){

							canvas.drawCircle(position.getInt("x") * scale,
									position.getInt("y") * scale,
									position.getInt("radius") * scale, overlayPaint);

						} else {
							rect.set(position.getInt("x") * scale,
									position.getInt("y") * scale,
									position.getInt("x") * scale + position.getInt("width") * scale,
									position.getInt("y") * scale + position.getInt("height") * scale);

							canvas.drawOval(rect, overlayPaint);
						}
						break;

					case "rect":
						rect.set(position.getInt("x") * scale,
								position.getInt("y") * scale,
								position.getInt("x") * scale + position.getInt("width") * scale,
								position.getInt("y") * scale + position.getInt("height") * scale);

						canvas.drawRect(rect, overlayPaint);
						break;
				}
			}
		}
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) { }

	public void setRegions(ReadableArray regions)
	{
		this.regions = regions;
	}
}