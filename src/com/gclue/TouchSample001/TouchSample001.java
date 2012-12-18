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

		// �N���X�̃C���X�^���X�𐶐�
		MyView mView = new MyView( this );

		// View�ɐݒ�
		setContentView( mView );
	}
}

/**
 * �`��p�̃N���X�B
 */
class MyView extends View {

	/** �摜��x���W�B */
	int x = 0;

	/** �摜��y���W�B */
	int y = 0;

	/** �摜���i�[����ϐ��B */
	private Bitmap myBitmap;

	/**
	 * �R���X�g���N�^�B
	 * @param context �R���e�L�X�g
	 */
	public MyView( Context context ) {
		super( context );
		setFocusable( true );

		// Resource�C���X�^���X�̐���
		Resources res = this.getContext().getResources();
		// �摜�̓ǂݍ���(res/drawable/gclue_logo.gif)
		myBitmap = BitmapFactory.decodeResource( res, R.drawable.gclue_logo );

	}

	/**
	 * �`�揈���B 
	 */
	@Override
	protected void onDraw( Canvas canvas ) {
		super.onDraw( canvas );

		// �w�i�F��ݒ�
		canvas.drawColor( Color.BLUE );

		// �`�悷�邽�߂̐��̐F��ݒ�
		Paint mainPaint = new Paint();
		mainPaint.setStyle( Paint.Style.FILL );
		mainPaint.setARGB( 255, 255, 255, 100 );

		// Bitmap�C���[�W�̕`��
		canvas.drawBitmap( myBitmap, x, y, mainPaint );
	}

	/** 
	 * �^�b�`�C�x���g�B
	 */
	@Override
	public boolean onTouchEvent( MotionEvent event ) {
		// �^�b�`�������Ɏ��s
		if ( event.getAction() == MotionEvent.ACTION_DOWN ) {
			// X,Y���W�̎擾
			x = (int) event.getX();
			y = (int) event.getY();
			// �ĕ`��̎w��
			invalidate();
		}
		return true;
	}
}