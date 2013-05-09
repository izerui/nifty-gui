package de.lessvoid.nifty.internal.layout;

import java.util.List;


/**
 * OverlayLayout doesn't layout things. It just forwards the size of the root box to the children.
 *
 * @author void
 */
public class InternalLayoutOverlay implements InternalLayout {

  public void layoutElements(final InternalLayoutable root, final List <? extends InternalLayoutable> children) {
    if (root == null || children == null || children.size() == 0) {
      return;
    }

    InternalBox rootBox = root.getLayoutPos();
    for (int i = 0; i < children.size(); i++) {
      InternalLayoutable p = children.get(i);
      InternalBox box = p.getLayoutPos();
      box.setX(0);
      box.setY(0);
      box.setWidth(rootBox.getWidth());
      box.setHeight(rootBox.getHeight());
    }
  }
}
