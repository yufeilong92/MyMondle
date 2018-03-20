# MyMondle
* 为什么你的自定义View wrap_content不起作用？ 
 >在onMeasure()中的getDefaultSize（）的默认实现中，当View的测量模式是AT_MOST或EXACTLY时，View的大小都会被设置成子View MeasureSpec的specSize。
 因为AT_MOST对应wrap_content；EXACTLY对应match_parent，所以，默认情况下，wrap_content和match_parent是具有相同的效果的。
 因为在计算子View MeasureSpec的getChildMeasureSpec()中，子View MeasureSpec在属性被设置为wrap_content或match_parent情况下，子View MeasureSpec的specSize被设置成parenSize = 父容器当前剩余空间大小
 所以：wrap_content起到了和match_parent相同的作用：等于父容器当前剩余空间大小
* 解决方案：
当自定义View的布局参数设置成wrap_content时时，指定一个默认大小（宽 / 高）。
>>具体是在复写onMeasure（）里进行设置

~~~
 @Override
     protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
 
         super.onMeasure(widthMeasureSpec, heightMeasureSpec);
 
 
         // 获取宽-测量规则的模式和大小
         int widthMode = MeasureSpec.getMode(widthMeasureSpec);
         int widthSize = MeasureSpec.getSize(widthMeasureSpec);
 
         // 获取高-测量规则的模式和大小
         int heightMode = MeasureSpec.getMode(heightMeasureSpec);
         int heightSize = MeasureSpec.getSize(heightMeasureSpec);
 
         // 设置wrap_content的默认宽 / 高值
         // 默认宽/高的设定并无固定依据,根据需要灵活设置
         // 类似TextView,ImageView等针对wrap_content均在onMeasure()对设置默认宽 / 高值有特殊处理,具体读者可以自行查看
         int mWidth = 400;
         int mHeight = 400;
 
       // 当布局参数设置为wrap_content时，设置默认值
         if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT && getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
             setMeasuredDimension(mWidth, mHeight);
         // 宽 / 高任意一个布局参数为= wrap_content时，都设置默认值
         } else if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT) {
             setMeasuredDimension(mWidth, heightSize);
         } else if (getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
             setMeasuredDimension(widthSize, mHeight);
         }
 
~~~
* 特别注意网上流传着这么一个解决方案
~~~
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


        // 获取宽-测量规则的模式和大小
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        // 获取高-测量规则的模式和大小
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        // 设置wrap_content的默认宽 / 高值
        // 默认宽/高的设定并无固定依据,根据需要灵活设置
        // 类似TextView,ImageView等针对wrap_content均在onMeasure()对设置默认宽 / 高值有特殊处理,具体读者可以自行查看
        int mWidth = 400;
        int mHeight = 400;

      // 当模式是AT_MOST（即wrap_content）时设置默认值
        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mWidth, mHeight);
        // 宽 / 高任意一个模式为AT_MOST（即wrap_content）时，都设置默认值
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mWidth, heightSize);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSize, mHeight);
        }

~~~
不过建议使用第一种
[详情解释](https://www.jianshu.com/p/ca118d704b5e)
* 支持padding属性padding属性：用于设置控件内容相对控件边缘的边距
>>在自定义View类的复写onDraw（）进行设置
~~~
// 仅看复写的onDraw（）
@Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        // 获取传入的padding值
        final int paddingLeft = getPaddingLeft();
        final int paddingRight = getPaddingRight();
        final int paddingTop = getPaddingTop();
        final int paddingBottom = getPaddingBottom();


        // 获取绘制内容的高度和宽度（考虑了四个方向的padding值）
        int width = getWidth() - paddingLeft - paddingRight ;
        int height = getHeight() - paddingTop - paddingBottom ;

        // 设置圆的半径 = 宽,高最小值的2分之1
        int r = Math.min(width, height)/2;

        // 画出圆(蓝色)
        // 圆心 = 控件的中央,半径 = 宽,高最小值的2分之1
        canvas.drawCircle(paddingLeft+width/2,paddingTop+height/2,r,mPaint1);

    }

~~~
* [详情请查看](https://www.jianshu.com/p/e9d8420b1b9c)