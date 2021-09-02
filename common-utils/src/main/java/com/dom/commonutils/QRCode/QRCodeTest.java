package com.dom.commonutils.QRCode;

/**
 * @description: 二维码生成测试
 * @author: Dom Frank
 * @create: 2021/09/02 18:48
 */
public class QRCodeTest {
    public static void main(String[] args) throws Exception {
        // 存放在二维码中的内容
        String text = "这是xiadayu";
        // 嵌入二维码的图片路径
        String imgPath = "D:/Develop/Test/xiadayu.jpg";
        // 生成的二维码的路径及名称
        String destPath = "D:/Develop/Test/xiadayuCode.jpg";
        //生成二维码
        QRCodeUtil.encode(text, imgPath, destPath, true);
        // 解析二维码
        String str = QRCodeUtil.decode(destPath);
        // 打印出解析出的内容
        System.out.println(str);

    }

}
