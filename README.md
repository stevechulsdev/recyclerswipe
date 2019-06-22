# Android Recycler Swipe Animation

<h4>리사이클러뷰에서 스와이프해서 리스트를 지우는 형태의 Custom View를 비교적 자주 사용하기에<p>
간편하게 사용 할 수 있도록 라이브러리를 만들었습니다.</h4>
<br>
<img src="https://github.com/stevechulsdev/recyclerswipe/raw/master/video/video.gif" width=25%>
<br>

# 라이브러리 적용 방법
<h3>프로젝트단의 build.gradle</h3>

<pre><code>
  buildscript {
    ...
    repositories {
      ...
      mavenCentral()
      jcenter()
      maven {
            url 'https://dl.bintray.com/stevechulsdev/maven/'
        }
    }
    dependencies {
      ...
    }
  }
  
  allprojects {
    repositories {
      ...
      mavenCentral()
      jcenter()
      maven {
        url 'https://dl.bintray.com/stevechulsdev/maven/'
      }
    }
  }
</code></pre>

<h3>앱단의 build.gradle</h3>

<pre><code>
  dependencies {
    ...
    implementation 'com.stevechulsdev.android:recycler-swipe:<strong>1.0.0</strong>@aar'
  }
</pre></code>
