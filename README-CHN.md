# SimpleEmTextView

  ### [中文版]()

- 基于原生TextView的自定义简单强调文字视图，可随时改变内容，字体颜色，字体大小。
- 作者：罗国文 
- 邮箱：luoguowen123@qq.com 


  ![SimpleEmTextView](https://raw.githubusercontent.com/lgw666/SimpleEmTextView/master/SimpleEmTextView.gif)

* ### 设置

  **Step 1. 添加JitPack到你的Project的build.gradle:**

  ```groovy
  	allprojects {
  		repositories {
  			...
  			maven { url 'https://jitpack.io' }
  		}
  	}
  ```

  ​

  **Step 2. 添加依赖:**

  ```groovy
  	dependencies {
  	        compile 'com.github.lgw666:SimpleEmTextView:v1.0'
  	}
  ```

  ​



* ### 使用方法

     **Step 1. 在布局中使用com.gavinrowe.lgw.library.SimpleEmTextView**

     ```xml
      <com.gavinrowe.lgw.library.SimpleEmTextView
        ...
        />
     ```

     ​

     **Step 2. 在xml或者java代码中设置强调内容、强调文字尺寸和颜色**

     ```xml
     <com.gavinrowe.lgw.library.SimpleEmTextView
        ...
        app:emText="强调"
        app:emTextColor="@color/colorEmText"
        app:emTextSize="36"
        app:emTextStyle="bold_italic"/>
     ```
    *tip: emTextStyle 有4个值，normal, bold, italic, bold_italic*
    
     ​	or

     ```Java
        SimpleEmTextView.setEmText(emText);
        SimpleEmTextView.setEmTextSize(emTextSize);
        SimpleEmTextView.setEmTextColor(emTextColor);
        SimpleEmTextView.setEmTextStyle(emTextStyle);
     ```

* ### 参数: 

   强调内容。

   ```Java
   String emText;
   ```

   强调内容文字尺寸。

   ```java
   int emTextSize;
   ```

   强调内容颜色，可以用ContextCompat.getColor(this, R.color.xxx), Color.xxx 和十六进制颜色格式.

   ```java
   int emTextColor
   ```
   
   强调内容文字风格，可以用Typeface.NORMAL，Typeface.BOLD，Typeface.ITALIC 和 Typeface.BOLD_ITALIC。

   ```java
   int emTextStyle
   ```
