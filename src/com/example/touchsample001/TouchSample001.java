package com.example.touchsample001;


import com.gclue.TouchSample001.R;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class TouchSample001 extends Activity {

	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		MyView mView = new MyView( this );
		setContentView( mView );
	}
}

class MyView extends View {

	int x = 0;

	int y = 0;

	private Bitmap myBitmap;

	public MyView( Context context ) {
		super( context );
		setFocusable( true );
		Resources res = this.getContext().getResources();
		myBitmap = BitmapFactory.decodeResource( res, R.drawable.gclue_logo );

	}

	@Override
	protected void onDraw( Canvas canvas ) {
		super.onDraw( canvas );

		canvas.drawColor( Color.BLUE );

		Paint mainPaint = new Paint();
		mainPaint.setStyle( Paint.Style.FILL );
		mainPaint.setARGB( 255, 255, 255, 100 );

		canvas.drawBitmap( myBitmap, x, y, mainPaint );
	}

	@Override
	public boolean onTouchEvent( MotionEvent event ) {
		if ( event.getAction() == MotionEvent.ACTION_DOWN ) {
			x = (int) event.getX();
			y = (int) event.getY();
			invalidate();
		}
		return true;
	}
}