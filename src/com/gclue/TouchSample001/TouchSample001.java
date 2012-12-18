package com.gclue.TouchSample001;


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

		// クラスのインスタンスを生成
		MyView mView = new MyView( this );

		// Viewに設定
		setContentView( mView );
	}
}

/**
 * 描画用のクラス。
 */
class MyView extends View {

	/** 画像のx座標。 */
	int x = 0;

	/** 画像のy座標。 */
	int y = 0;

	/** 画像を格納する変数。 */
	private Bitmap myBitmap;

	/**
	 * コンストラクタ。
	 * @param context コンテキスト
	 */
	public MyView( Context context ) {
		super( context );
		setFocusable( true );

		// Resourceインスタンスの生成
		Resources res = this.getContext().getResources();
		// 画像の読み込み(res/drawable/gclue_logo.gif)
		myBitmap = BitmapFactory.decodeResource( res, R.drawable.gclue_logo );

	}

	/**
	 * 描画処理。 
	 */
	@Override
	protected void onDraw( Canvas canvas ) {
		super.onDraw( canvas );

		// 背景色を設定
		canvas.drawColor( Color.BLUE );

		// 描画するための線の色を設定
		Paint mainPaint = new Paint();
		mainPaint.setStyle( Paint.Style.FILL );
		mainPaint.setARGB( 255, 255, 255, 100 );

		// Bitmapイメージの描画
		canvas.drawBitmap( myBitmap, x, y, mainPaint );
	}

	/** 
	 * タッチイベント。
	 */
	@Override
	public boolean onTouchEvent( MotionEvent event ) {
		// タッチした時に実行
		if ( event.getAction() == MotionEvent.ACTION_DOWN ) {
			// X,Y座標の取得
			x = (int) event.getX();
			y = (int) event.getY();
			// 再描画の指示
			invalidate();
		}
		return true;
	}
}