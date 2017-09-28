package com.christhoma.commuted;

import android.support.annotation.DrawableRes;
import android.util.Log;

import java.util.Random;

public class ImageProvider {

    static Random random = new Random();
    @DrawableRes
    static int[] firstBucket = {
            R.drawable.img_1858,
            R.drawable.img_1859,
            R.drawable.img_1860,
            R.drawable.img_1861,
            R.drawable.img_1862,
            R.drawable.img_1863,
            R.drawable.img_1864
    };
    @DrawableRes
    static int[] secondBucket = {
            R.drawable.img_1865,
            R.drawable.img_1866,
            R.drawable.img_1867,
            R.drawable.img_1868,
            R.drawable.img_1869,
            R.drawable.img_1870,
            R.drawable.img_1871
    };
    @DrawableRes
    static int[] thirdBucket = {
            R.drawable.img_1872,
            R.drawable.img_1873,
            R.drawable.img_1874,
            R.drawable.img_1875,
            R.drawable.img_1876,
            R.drawable.img_1877,
            R.drawable.img_1878
    };
    @DrawableRes
    static int[] fourthBucket = {
            R.drawable.img_1880,
            R.drawable.img_1881,
            R.drawable.img_1882,
            R.drawable.img_1886,
            R.drawable.img_1887,
            R.drawable.img_1888,
            R.drawable.img_1889
    };
    @DrawableRes
    static int[] fifthBucket = {
            R.drawable.img_1891,
            R.drawable.img_1892,
            R.drawable.img_1893,
            R.drawable.img_1894,
            R.drawable.img_1895,
            R.drawable.img_1896,
            R.drawable.img_1897
    };
    @DrawableRes
    static int[] sixthBucket = {
            R.drawable.img_1898,
            R.drawable.img_1899,
            R.drawable.img_1900,
            R.drawable.img_1901,
            R.drawable.img_1902,
            R.drawable.img_1903,
            R.drawable.img_1904
    };
    @DrawableRes
    static int[] seventhBucket = {
            R.drawable.img_1906,
            R.drawable.img_1907,
            R.drawable.img_1908,
            R.drawable.img_1909,
            R.drawable.img_1910,
            R.drawable.img_1911,
            R.drawable.img_1912
    };
    @DrawableRes
    static int[] eighthBucket = {
            R.drawable.img_1913,
            R.drawable.img_1914,
            R.drawable.img_1915,
            R.drawable.img_1916,
            R.drawable.img_1917
    };
    @DrawableRes
    static int[] ninthBucket = {
            R.drawable.img_1918,
            R.drawable.img_1919,
            R.drawable.img_1920,
            R.drawable.img_1921,
            R.drawable.img_1912,
            R.drawable.img_1923
    };

    private static final String TAG = "ImageProvider";

    @DrawableRes
    public static int getImageForBucket(int bucket) {
        int itemId;
        switch (bucket) {
            case 1:
                itemId = random.nextInt(firstBucket.length - 1);
                Log.d(TAG, "getImageForBucket: " + itemId);
                return firstBucket[itemId];
            case 2:
                itemId = random.nextInt(secondBucket.length - 1);
                Log.d(TAG, "getImageForBucket: " + itemId);
                return secondBucket[itemId];
            case 3:
                itemId = random.nextInt(thirdBucket.length - 1);
                Log.d(TAG, "getImageForBucket: " + itemId);
                return thirdBucket[itemId];
            case 4:
                itemId = random.nextInt(fourthBucket.length - 1);
                Log.d(TAG, "getImageForBucket: " + itemId);
                return fourthBucket[itemId];
            case 5:
                itemId = random.nextInt(fifthBucket.length - 1);
                Log.d(TAG, "getImageForBucket: " + itemId);
                return fifthBucket[itemId];
            case 6:
                itemId = random.nextInt(sixthBucket.length - 1);
                Log.d(TAG, "getImageForBucket: " + itemId);
                return sixthBucket[itemId];
            case 7:
                itemId = random.nextInt(seventhBucket.length - 1);
                Log.d(TAG, "getImageForBucket: " + itemId);
                return seventhBucket[itemId];
            case 8:
                itemId = random.nextInt(eighthBucket.length - 1);
                Log.d(TAG, "getImageForBucket: " + itemId);
                return eighthBucket[itemId];
            case 9:
                itemId = random.nextInt(ninthBucket.length - 1);
                Log.d(TAG, "getImageForBucket: " + itemId);
                return ninthBucket[itemId];
            default:
                return 0;
        }
    }
}
