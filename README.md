# 2019년 상반기 following Android edu streaming by 정석준의 개발저장소


> 툴바 제거  
  * styles.xml
    * item name="windowActionBar" : false
    * item name="windowNoTitle" : true
> 색 추가
  * https://color.adobe.com - 탐색
  * Mac - 디지털 컬러 측정기
    * 보기 - 값 표시 - 16진수
    * 복사 : command + shift + C
    * 붙여넣기 : command + V
  * colors.xml
    * item 추가
> left drawer layout 추가  
> 왼쪽에서 클릭 후 오른쪽으로 드래그하면 숨겨져있던 layout이 등장함
```xml
<!-- 
FrameLayout 속성 중
android:layout_gravity="start" 중요 
-->
<DrawerLayout
    match_parent>
    <ConstraintLayout
        match_parent/>
    <FrameLayout
        match_parent
        android:layout_gravity="start">
    </FrameLayout>
</DrawerLayout>
```
> 버튼 클릭 이벤트 추가
* 생략
> right drawer layout / 버튼 추가
* 생략
> full screen drawer layout
```xml
android:layout_marginEnd="-65dp"
android:layout_marginStart="-65dp"
```
> addDrawerListener / DrawerLayout.DrawerListener / onDrawerStateChanged
* drawer 상태에 따라 표시
* override fun onDrawerStateChanged(newState: Int)
  * DrawerLayout.STATE_IDLE : 멈췄을 때
  * DrawerLayout.STATE_DRAGGING : ?
  * DrawerLayout.STATE_SETTLING : 처음 움직이기 직전
    * 그다음, onDrawerSlide 호출
* override fun onDrawerSlide(drawerView: View, slideOffset: Float)
  * 움직일 때
  * slideOffset 값이 0.0부터 1.0까지 변함
* override fun onDrawerClosed(drawerView: View)
  * 완전히 닫혔을 때 호출
  * 그다음, DrawerLayout.STATE_IDLE 호출
* override fun onDrawerOpened(drawerView: View)
  * 완전히 열렸을 때 호출
  * 그다음, DrawerLayout.STATE_IDLE 호출
#
#
# ?
## 단축키
> Ctrl(^) + G
* 선택한 블록부터 아래 동일한 블록 1개씩 선택