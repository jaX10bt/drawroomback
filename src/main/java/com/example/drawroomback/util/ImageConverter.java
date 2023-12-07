package com.example.drawroomback.util;

import com.example.drawroomback.domain.image.Image;
import jakarta.validation.constraints.NotNull;

import java.nio.charset.StandardCharsets;

public class ImageConverter {
    public static byte[] stringToByteArray(String imageData) {
        if (imageData == null) {
            return null;
        }
        return imageData.getBytes(StandardCharsets.UTF_8);
    }

    public static Image stringToImage(String imageData) {
        if (imageData == null) {
            return null;
        }
        Image image = new Image();
        image.setData(stringToByteArray(imageData));
        return image;
    }

    public static String imageToString(Image image) {
        if (image == null) {
            return "";
        }

        byte[] bytes = image.getData();
        if (bytes == null) {
            return "";
        }
        return byteArrayToString(bytes);


    }

    public static String byteArrayToString(byte[] bytes) {
        if (bytes == null) {
            return "";
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
