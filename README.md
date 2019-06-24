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
      <strong>mavenCentral()</strong>
      <strong>jcenter()</strong>
      <strong>maven { url 'https://dl.bintray.com/stevechulsdev/maven/' }</strong>
    }
    dependencies {
      ...
    }
  }
  
  allprojects {
    repositories {
      ...
      <strong>mavenCentral()</strong>
      <strong>jcenter()</strong>
      <strong>maven { url 'https://dl.bintray.com/stevechulsdev/maven/' }</strong>
    }
  }
</code></pre>

<h3>앱단의 build.gradle</h3>

<pre><code>
  dependencies {
    ...
    <strong>implementation 'com.stevechulsdev.android:recycler-swipe:<strong>1.0.0</strong>@aar'</strong>
  }
</pre></code>

# Kotlin 코드 적용
<h3>Activity, Fragment단에서 호출</h3>
Class명을 바꿨는데, 적용이 바로 안되는 것 같습니다
<br>
<strong>StevechulsSwipeHelper</strong>가 호출이 안되면, <strong>SwipeHelper</strong>로 호출해서 사용하시길 바랍니다.
<br>
<h4>UnderlayButton Parameter</h4><br>
@param <strong>Icon Resource</strong><br>
@param <strong>Icon Width</strong><br>
@param <strong>Icon Height</strong><br>
@param <strong>Button Width</strong><br>
@param <strong>Button Background Color</strong><br>
@param <strong>UnderlayButtonClickListener</strong><br>
@param <strong>Context</strong><br>
<pre><code>
  object : StevechulsSwipeHelper(this, recycler) {
            override fun instantiateUnderlayButton(
                viewHolder: RecyclerView.ViewHolder, 
                underlayButtons: MutableList<UnderlayButton>) {
                    // one button
                    underlayButtons.add(
                        UnderlayButton(R.drawable.icon_garbage, 250, 250, 200,
                            Color.parseColor("#e5001b"),
                            UnderlayButtonClickListener { pos ->
                                recycler.adapter?.notifyItemChanged(pos)
                                adapter.removeItemToSwipe(pos)
                            }, this@MainActivity
                        )
                    )
                    // two button
                    underlayButtons.add(
                        UnderlayButton(R.drawable.icon_garbage, 250, 250, 200,
                            Color.parseColor("#e5001b"),
                            UnderlayButtonClickListener { pos ->
                                recycler.adapter?.notifyItemChanged(pos)
                                adapter.removeItemToSwipe(pos)
                            }, this@MainActivity
                        )
                    )
            }
        }
</pre></code>
