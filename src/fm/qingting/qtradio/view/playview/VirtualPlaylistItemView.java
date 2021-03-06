package fm.qingting.qtradio.view.playview;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View.MeasureSpec;
import fm.qingting.framework.view.ButtonViewElement;
import fm.qingting.framework.view.ImageViewElement;
import fm.qingting.framework.view.QtView;
import fm.qingting.framework.view.TextViewElement;
import fm.qingting.framework.view.ViewElement;
import fm.qingting.framework.view.ViewElement.OnElementClickListener;
import fm.qingting.framework.view.ViewLayout;
import fm.qingting.qtradio.controller.ControllerManager;
import fm.qingting.qtradio.fm.PlayerAgent;
import fm.qingting.qtradio.manager.SkinManager;
import fm.qingting.qtradio.model.InfoManager;
import fm.qingting.qtradio.model.Node;
import fm.qingting.qtradio.model.ProgramNode;
import fm.qingting.qtradio.model.RootNode;
import java.util.Locale;

public class VirtualPlaylistItemView extends QtView
{
  private static final String MODEL_HOUR_MINUTE = "时长：%d时%d分";
  private static final String MODEL_MINITE = "时长：%d分";
  private static final String MODEL_MINITE_SECOND = "时长：%d分%d秒";
  private static final String MODEL_SECOND = "时长：%d秒";
  private final ViewLayout arrowLayout = this.itemLayout.createChildLT(36, 36, 650, 50, ViewLayout.SCALE_FLAG_SLTCW);
  private final ViewLayout infoLayout = this.itemLayout.createChildLT(600, 45, 30, 75, ViewLayout.SCALE_FLAG_SLTCW);
  private final ViewLayout itemLayout = ViewLayout.createViewLayoutWithBoundsLT(720, 136, 720, 800, 0, 0, ViewLayout.SCALE_FLAG_SLTCW);
  private final ViewLayout lineLayout = this.itemLayout.createChildLT(690, 1, 30, 135, ViewLayout.SCALE_FLAG_SLTCW);
  private final ViewLayout livingLayout = this.itemLayout.createChildLT(50, 26, 30, 29, ViewLayout.SCALE_FLAG_SLTCW);
  private ImageViewElement mArrowElement;
  private ButtonViewElement mBgElement;
  private TextViewElement mInfoElement;
  private boolean mIsPlaying = false;
  private LineElement mLineElement;
  private TextViewElement mNameElement;
  private ProgramNode mNode;
  private ImageViewElement mStateElement;
  private final ViewLayout nameLayout = this.itemLayout.createChildLT(600, 45, 30, 20, ViewLayout.SCALE_FLAG_SLTCW);

  public VirtualPlaylistItemView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mBgElement = new ButtonViewElement(paramContext);
    this.mBgElement.setBackgroundColor(SkinManager.getItemHighlightMaskColor(), 0);
    addElement(this.mBgElement);
    this.mBgElement.setOnElementClickListener(new ViewElement.OnElementClickListener()
    {
      public void onElementClick(ViewElement paramAnonymousViewElement)
      {
        VirtualPlaylistItemView.this.handleClick();
      }
    });
    this.mNameElement = new TextViewElement(paramContext);
    this.mNameElement.setMaxLineLimit(1);
    this.mNameElement.setColor(-1);
    addElement(this.mNameElement);
    this.mInfoElement = new TextViewElement(paramContext);
    this.mInfoElement.setMaxLineLimit(1);
    this.mInfoElement.setColor(SkinManager.getNewPlaySubColor());
    addElement(this.mInfoElement);
    this.mStateElement = new ImageViewElement(paramContext);
    this.mStateElement.setImageRes(2130837921);
    addElement(this.mStateElement, paramInt);
    this.mLineElement = new LineElement(paramContext);
    this.mLineElement.setColor(872415231);
    this.mLineElement.setOrientation(1);
    addElement(this.mLineElement);
    this.mArrowElement = new ImageViewElement(paramContext);
    this.mArrowElement.setImageRes(2130837694);
    addElement(this.mArrowElement, paramInt);
  }

  private String getDurationTime(int paramInt)
  {
    int i = paramInt / 3600;
    int j = paramInt / 60 % 60;
    int k = paramInt % 60;
    if (i == 0)
    {
      if (k == 0)
      {
        Locale localLocale4 = Locale.CHINA;
        Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[0] = Integer.valueOf(j);
        return String.format(localLocale4, "时长：%d分", arrayOfObject4);
      }
      if (j == 0)
      {
        Locale localLocale3 = Locale.CHINA;
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = Integer.valueOf(k);
        return String.format(localLocale3, "时长：%d秒", arrayOfObject3);
      }
      Locale localLocale2 = Locale.CHINA;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Integer.valueOf(j);
      arrayOfObject2[1] = Integer.valueOf(k);
      return String.format(localLocale2, "时长：%d分%d秒", arrayOfObject2);
    }
    Locale localLocale1 = Locale.CHINA;
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Integer.valueOf(i);
    arrayOfObject1[1] = Integer.valueOf(j);
    return String.format(localLocale1, "时长：%d时%d分", arrayOfObject1);
  }

  private void handleClick()
  {
    if (this.mNode == null)
      return;
    PlayerAgent.getInstance().play(this.mNode);
    ControllerManager.getInstance().popLastController();
  }

  private boolean isPlaying(ProgramNode paramProgramNode)
  {
    if (paramProgramNode == null)
      return false;
    Node localNode = InfoManager.getInstance().root().getCurrentPlayingNode();
    if (localNode == null)
      return false;
    if (!this.mNode.nodeName.equalsIgnoreCase(localNode.nodeName))
      return false;
    return this.mNode.uniqueId == ((ProgramNode)localNode).uniqueId;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    TextViewElement localTextViewElement = this.mNameElement;
    if (this.mIsPlaying);
    for (int i = this.livingLayout.width; ; i = 0)
    {
      localTextViewElement.setTranslationX(i);
      super.onDraw(paramCanvas);
      return;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.itemLayout.scaleToBounds(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    this.nameLayout.scaleToBounds(this.itemLayout);
    this.infoLayout.scaleToBounds(this.itemLayout);
    this.arrowLayout.scaleToBounds(this.itemLayout);
    this.lineLayout.scaleToBounds(this.itemLayout);
    this.livingLayout.scaleToBounds(this.itemLayout);
    this.mNameElement.measure(this.nameLayout);
    this.mInfoElement.measure(this.infoLayout);
    this.mArrowElement.measure(this.arrowLayout);
    this.mBgElement.measure(this.itemLayout);
    this.mStateElement.measure(this.livingLayout);
    this.mLineElement.measure(this.lineLayout);
    this.mNameElement.setTextSize(SkinManager.getInstance().getNormalTextSize());
    this.mInfoElement.setTextSize(SkinManager.getInstance().getSubTextSize());
    setMeasuredDimension(this.itemLayout.width, this.itemLayout.height);
  }

  public void update(String paramString, Object paramObject)
  {
    ImageViewElement localImageViewElement;
    if (paramString.equalsIgnoreCase("content"))
    {
      this.mNode = ((ProgramNode)paramObject);
      this.mIsPlaying = isPlaying(this.mNode);
      localImageViewElement = this.mStateElement;
      if (!this.mIsPlaying)
        break label86;
    }
    label86: for (int i = 0; ; i = 4)
    {
      localImageViewElement.setVisible(i);
      this.mNameElement.setText(this.mNode.title, false);
      this.mInfoElement.setText(getDurationTime(this.mNode.getDuration()));
      return;
    }
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.view.playview.VirtualPlaylistItemView
 * JD-Core Version:    0.6.2
 */