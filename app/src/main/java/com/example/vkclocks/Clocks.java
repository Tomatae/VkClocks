package com.example.vkclocks;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Clocks extends View {
    private final Paint clockPaint;
    private final Paint handPaint;
    private final Paint mHandPaint;
    private final Paint sHandPaint;

    public Clocks(Context context, AttributeSet attrs) {
        super(context, attrs);
        clockPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        clockPaint.setColor(Color.BLACK);
        clockPaint.setStyle(Paint.Style.STROKE);
        clockPaint.setStrokeWidth(8f);

        handPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        handPaint.setColor(Color.BLACK);
        handPaint.setStrokeWidth(14f);

        mHandPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mHandPaint.setColor(Color.BLACK);
        mHandPaint.setStrokeWidth(8f);

        sHandPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        sHandPaint.setColor(Color.BLACK);
        sHandPaint.setStrokeWidth(4f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int timeShift = 3;
        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height) / 2;
        int centerX = width / 2;
        int centerY = height / 2;
        long now = System.currentTimeMillis();
        int hours = (int) ((now / (1000 * 60 * 60)) % 12);
        int minutes = (int) ((now / (1000 * 60)) % 60);
        int seconds = (int) ((now / 1000) % 60);

        canvas.drawCircle(centerX, centerY, radius, clockPaint);

        canvas.save();
        canvas.rotate(30 * (hours + timeShift) + 0.25f * minutes + 0.0083f * seconds, centerX, centerY);
        canvas.drawLine(centerX, centerY, centerX, (float) (centerY - radius * 0.45), handPaint);
        canvas.restore();

        canvas.save();
        canvas.rotate(6 * minutes + 0.1f * seconds, centerX, centerY);
        canvas.drawLine(centerX, centerY, centerX, (float) (centerY - radius * 0.7), mHandPaint);
        canvas.restore();

        canvas.save();
        canvas.rotate(6 * seconds, centerX, centerY);
        canvas.drawLine(centerX, centerY, centerX, (float) (centerY - radius * 0.85), sHandPaint);
        canvas.restore();

        invalidate();
    }
}
