package fm.qingting.qtradio.model;

import java.util.ArrayList;

public class DjRadiosInfo
{
  public ArrayList<DjRadioElement> lstDjRadioElements = new ArrayList();
  public String title = null;

  public void addDjRadioElement(DjRadioElement paramDjRadioElement)
  {
    this.lstDjRadioElements.add(paramDjRadioElement);
  }

  public ArrayList<DjRadioElement> getDjRadioElementList()
  {
    return this.lstDjRadioElements;
  }

  public String getTitle()
  {
    return this.title;
  }

  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
}

/* Location:           /Users/zhangxun-xy/Downloads/qingting2/classes_dex2jar.jar
 * Qualified Name:     fm.qingting.qtradio.model.DjRadiosInfo
 * JD-Core Version:    0.6.2
 */