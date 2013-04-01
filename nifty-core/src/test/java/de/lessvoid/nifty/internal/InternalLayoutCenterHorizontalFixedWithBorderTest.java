package de.lessvoid.nifty.internal;

import org.junit.Before;
import org.junit.Test;

import de.lessvoid.nifty.api.Assert;
import de.lessvoid.nifty.api.HorizontalAlignment;
import de.lessvoid.nifty.api.UnitValue;
import de.lessvoid.nifty.internal.InternalBox;
import de.lessvoid.nifty.internal.InternalBoxConstraints;
import de.lessvoid.nifty.internal.InternalLayoutCenter;

public class InternalLayoutCenterHorizontalFixedWithBorderTest {
  private InternalLayoutCenter layout;
  private InternalBox rootBox;
  private InternalBox box;
  private InternalBoxConstraints constraint;
  private InternalBoxConstraints rootBoxConstraints;

  @Before
  public void setUp() throws Exception {
    layout = new InternalLayoutCenter();

    rootBox = new InternalBox(0, 0, 640, 480);

    rootBoxConstraints = new InternalBoxConstraints();
    rootBoxConstraints.setPadding(new UnitValue("50px"));

    box = new InternalBox();

    constraint = new InternalBoxConstraints();
    constraint.setWidth(new UnitValue("100px"));
  }

  @Test
  public void testHorizontalAlignDefaultFixedWidth() {
    // defauls to left right now
    layout.handleHorizontalAlignment(rootBox, rootBoxConstraints, box, constraint);
    Assert.assertBoxLeftWidth(box, 270, 100);
  }

  @Test
  public void testHorizontalAlignLeftFixedWidth() {
    constraint.setHorizontalAlign(HorizontalAlignment.left);
    layout.handleHorizontalAlignment(rootBox, rootBoxConstraints, box, constraint);
    Assert.assertBoxLeftWidth(box, 50, 100);
  }

  @Test
  public void testHorizontalAlignRightFixedWidth() {
    constraint.setHorizontalAlign(HorizontalAlignment.right);
    layout.handleHorizontalAlignment(rootBox, rootBoxConstraints, box, constraint);
    Assert.assertBoxLeftWidth(box, 640 - 100, 100);
  }

  @Test
  public void testHorizontalAlignCenterFixedWidth() {
    constraint.setHorizontalAlign(HorizontalAlignment.center);
    layout.handleHorizontalAlignment(rootBox, rootBoxConstraints, box, constraint);
    Assert.assertBoxLeftWidth(box, 270, 100);
  }
}