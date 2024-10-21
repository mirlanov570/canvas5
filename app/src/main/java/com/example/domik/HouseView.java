package com.example.domik;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class HouseView extends View {

    private Paint paint;

    public HouseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.GREEN);
        float grassTop = getHeight() * 2 / 3 - 100;
        canvas.drawRect(0, grassTop, getWidth(), getHeight(), paint);

        paint.setColor(Color.rgb(150, 75, 0));
        float houseLeft = getWidth() / 4;
        float houseTop = getHeight() / 2;
        float houseRight = getWidth() * 3 / 4;
        float houseBottom = getHeight() * 2 / 3;
        canvas.drawRect(houseLeft, houseTop, houseRight, houseBottom, paint);

        paint.setColor(Color.rgb(150, 75, 0));
        Path roofPath = new Path();
        roofPath.moveTo(houseLeft, houseTop);
        roofPath.lineTo(getWidth() / 2, getHeight() / 3);
        roofPath.lineTo(houseRight, houseTop);
        roofPath.close();
        canvas.drawPath(roofPath, paint);

        float sphereCenterX = getWidth() / 2;
        float sphereCenterY = (houseTop + getHeight() / 3) / 2;
        float sphereRadius = 40;
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(sphereCenterX, sphereCenterY, sphereRadius, paint);

        paint.setColor(Color.BLACK);
        int knumLines = 6;

        for (int i = -knumLines; i <= knumLines; i++) {
            float x = sphereCenterX + (sphereRadius * (float) Math.sin(i * Math.PI / knumLines));
            float yStart = sphereCenterY - (sphereRadius * (float) Math.cos(i * Math.PI / knumLines));
            float yEnd = sphereCenterY + (sphereRadius * (float) Math.cos(i * Math.PI / knumLines));
            canvas.drawLine(x, yStart, x, yEnd, paint);
        }

        for (int i = -knumLines; i <= knumLines; i++) {
            float y = sphereCenterY + (sphereRadius * (float) Math.sin(i * Math.PI / knumLines));
            float xStart = sphereCenterX - (sphereRadius * (float) Math.cos(i * Math.PI / knumLines));
            float xEnd = sphereCenterX + (sphereRadius * (float) Math.cos(i * Math.PI / knumLines));
            canvas.drawLine(xStart, y, xEnd, y, paint);
        }

        paint.setColor(Color.BLACK);
        float lineY = houseBottom;
        canvas.drawLine(houseLeft, lineY, houseRight, lineY, paint);
        canvas.drawLine(houseLeft, houseTop, houseRight, houseTop, paint);

        paint.setColor(Color.rgb(139, 69, 19));
        float trunkLeft = getWidth() * 3 / 4 + 30;
        float trunkTop = getHeight() * 2 / 3;
        float trunkWidth = 30;
        float trunkHeight = 100;
        canvas.drawRect(trunkLeft, trunkTop, trunkLeft + trunkWidth, trunkTop + trunkHeight, paint);

        paint.setColor(Color.rgb(34, 139, 34));
        float leavesCenterX = getWidth() * 3 / 4 + 30;
        float leavesCenterY = trunkTop - 40;
        float leavesRadius = 100;
        canvas.drawCircle(leavesCenterX, leavesCenterY, leavesRadius, paint);

        paint.setColor(Color.YELLOW);
        float sunX = 100;
        float sunY = 100;
        float sunRadius = 80;
        canvas.drawCircle(sunX, sunY, sunRadius, paint);

        int numRays = 12;
        float rayLength = 80;
        for (int i = 0; i < numRays; i++) {
            float angle = (float) (i * (2 * Math.PI / numRays));
            float startX = sunX + sunRadius * (float) Math.cos(angle);
            float startY = sunY + sunRadius * (float) Math.sin(angle);
            float endX = sunX + (sunRadius + rayLength) * (float) Math.cos(angle);
            float endY = sunY + (sunRadius + rayLength) * (float) Math.sin(angle);
            canvas.drawLine(startX, startY, endX, endY, paint);
        }

        paint.setColor(Color.RED);
        float windowLeft = houseLeft + 20;
        float windowTop = houseTop + 80;
        float windowSize = 180;
        canvas.drawRect(windowLeft, windowTop, windowLeft + windowSize, windowTop + windowSize, paint);

        paint.setColor(Color.BLACK);
        int numLines = 4;
        float step = windowSize / (numLines + 1);

        for (int i = 1; i <= numLines; i++) {
            float y = windowTop + i * step;
            canvas.drawLine(windowLeft, y, windowLeft + windowSize, y, paint);
        }

        for (int i = 1; i <= numLines; i++) {
            float x = windowLeft + i * step;
            canvas.drawLine(x, windowTop, x, windowTop + windowSize, paint);
        }

        paint.setColor(Color.rgb(139, 69, 19));
        float doorLeft = houseRight - 250;
        float doorTop = houseBottom - 180;
        float doorWidth = 150;
        float doorHeight = 180;
        canvas.drawRect(doorLeft, doorTop, doorLeft + doorWidth, doorTop + doorHeight, paint);

        paint.setColor(Color.BLACK);
        for (int i = 1; i <= 3; i++) {
            float y = doorTop + i * (doorHeight / 4);
            canvas.drawLine(doorLeft, y, doorLeft + doorWidth, y, paint);
        }

        for (int i = 1; i <= 2; i++) {
            float x = doorLeft + i * (doorWidth / 3);
            canvas.drawLine(x, doorTop, x, doorTop + doorHeight, paint);
        }

        paint.setColor(Color.rgb(139, 69, 19));
        float benchWidth = 200;
        float benchHeight = 20;
        float benchLeft = getWidth() / 4;
        float benchTop = houseBottom + 10;

        canvas.drawRect(benchLeft, benchTop, benchLeft + benchWidth, benchTop + benchHeight, paint);

        float legWidth = 10;
        float legHeight = 40;
        float leftLegX = benchLeft;
        float rightLegX = benchLeft + benchWidth;

        canvas.drawRect(leftLegX, benchTop + benchHeight, leftLegX + legWidth, benchTop + benchHeight + legHeight, paint);
        canvas.drawRect(rightLegX - legWidth, benchTop + benchHeight, rightLegX, benchTop + benchHeight + legHeight, paint);
    }
}
