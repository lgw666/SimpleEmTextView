# SimpleEmTextView

  ### [中文版](https://github.com/lgw666/SimpleEmTextView/blob/master/README-CHN.md)

- A simple emphasis text view android.support.v7.widget.AppCompatTextView - You can decide when to change content, text color and text size.
- Author: Luo Guowen 
- Email: luoguowen123@qq.com


  ![image](https://github.com/lgw666/SimpleToast/blob/master/SimpleToastDemo.gif)

* ### Setup

  **Step 1. Add the JitPack repository to your build file Add it in your root build.gradle at the end of repositories:**

  ```groovy
  	allprojects {
  		repositories {
  			...
  			maven { url 'https://jitpack.io' }
  		}
  	}
  ```

  ​

  **Step 2. Add the dependency：**

  ```groovy
  	dependencies {
  	        compile 'com.github.lgw666:SimpleEmTextView:v1.0'
  	}
  ```

  ​



* ### Usage

     **Step 1. Use com.gavinrowe.lgw.library.SimpleEmTextView in your layout**

     ```xml
      <com.gavinrowe.lgw.library.SimpleEmTextView
        ...
        />
     ```

     ​

     **Step 2. Set your emphasis content, text size and text color by using xml or java code**

     ```xml
     <com.gavinrowe.lgw.library.SimpleEmTextView
        ...
        app:emText="强调"
        app:emTextColor="@color/colorEmText"
        app:emTextSize="36"
        app:emTextStyle="bold_italic"/>
     ```
    *tip: emTextStyle has 4 choices, such as: normal, bold, italic, bold_italic*
    
     ​	or

     ```Java
        SimpleEmTextView.setEmText(emText);
        SimpleEmTextView.setEmTextSize(emTextSize);
        SimpleEmTextView.setEmTextColor(emTextColor);
        SimpleEmTextView.setEmTextStyle(emTextStyle);
     ```

* ### Params: 

   Emphasis content.

   ```Java
   String emText;
   ```

   Emphasis text size.

   ```java
   int emTextSize;
   ```

   Emphasis text color, you can use ContextCompat.getColor(this, R.color.xxx), Color.xxx and hexadecimal.

   ```java
   int emTextColor
   ```
   
   Emphasis text style, you can use Typeface.NORMAL, Typeface.BOLD, Typeface.ITALIC and Typeface.BOLD_ITALIC.

   ```java
   int emTextStyle
   ```
