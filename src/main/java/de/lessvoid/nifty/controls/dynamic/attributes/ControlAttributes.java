package de.lessvoid.nifty.controls.dynamic.attributes;


import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.StandardControl;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.layout.LayoutPart;
import de.lessvoid.nifty.loaderv2.types.ControlType;
import de.lessvoid.nifty.loaderv2.types.EffectsType;
import de.lessvoid.nifty.loaderv2.types.ElementType;
import de.lessvoid.nifty.loaderv2.types.ImageType;
import de.lessvoid.nifty.loaderv2.types.LabelType;
import de.lessvoid.nifty.loaderv2.types.LayerType;
import de.lessvoid.nifty.loaderv2.types.PanelType;
import de.lessvoid.nifty.loaderv2.types.TextType;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.xml.xpp3.Attributes;

public class ControlAttributes {
  protected Attributes attributes = new Attributes();
  private ControlInteractAttributes interact;
  private ControlEffectsAttributes effects;
  
  public void setInteract(final ControlInteractAttributes controlInteract) {
    interact = controlInteract;
  }

  public void setEffects(final ControlEffectsAttributes controlEffects) {
    effects = controlEffects;
  }

  public void set(final String key, final String value) {
    attributes.set(key, value);
  }

  public void setId(final String id) {
    attributes.set("id", id);
  }

  public void setName(final String name) {
    attributes.set("name", name);
  }

  public void setHeight(final String height) {
    attributes.set("height", height);
  }

  public void setWidth(final String width) {
    attributes.set("width", width);
  }

  public void setX(final String x) {
    attributes.set("x", x);
  }

  public void setY(final String y) {
    attributes.set("y", y);
  }

  public void setAlign(final String align) {
    attributes.set("align", align);
  }

  public void setVAlign(final String valign) {
    attributes.set("valign", valign);
  }

  public void setPaddingLeft(final String paddingLeft) {
    attributes.set("paddingLeft", paddingLeft);
  }

  public void setPaddingRight(final String paddingRight) {
    attributes.set("paddingRight", paddingRight);
  }

  public void setPaddingTop(final String paddingTop) {
    attributes.set("paddingTop", paddingTop);
  }

  public void setPaddingBottom(final String paddingBottom) {
    attributes.set("paddingBottom", paddingBottom);
  }

  public void setChildClip(final String childClip) {
    attributes.set("childClip", childClip);
  }

  public void setVisible(final String visible) {
    attributes.set("visible", visible);
  }

  public void setVisibleToMouse(final String visibleToMouse) {
    attributes.set("visibleToMouse", visibleToMouse);
  }

  public void setChildLayout(final String childLayout) {
    attributes.set("childLayout", childLayout);
  }

  public void setFocusable(final String focusable) {
    attributes.set("focusable", focusable);
  }

  public void setFont(final String font) {
    attributes.set("font", font);
  }

  public void setTextHAlign(final String textHAlign) {
    attributes.set("textHAlign", textHAlign);
  }

  public void setTextVAlign(final String textVAlign) {
    attributes.set("textVAlign", textVAlign);
  }

  public void setColor(final String color) {
    attributes.set("color", color);
  }

  public void setSelectionColor(final String selectionColor) {
    attributes.set("selectionColor", selectionColor);
  }

  public void setText(final String text) {
    attributes.set("text", text);
  }

  public void setBackgroundColor(final String backgroundColor) {
    attributes.set("backgroundColor", backgroundColor);
  }

  public void setBackgroundImage(final String backgroundImage) {
    attributes.set("backgroundImage", backgroundImage);
  }

  public void setImageMode(final String imageMode) {
    attributes.set("imageMode", imageMode);
  }

  public void setFilename(final String filename) {
    attributes.set("filename", filename);
  }

  public void setInset(final String inset) {
    attributes.set("inset", inset);
  }

  public void setController(final String controller) {
    attributes.set("controller", controller);
  }

  public void setInputMapping(final String inputMapping) {
    attributes.set("inputMapping", inputMapping);
  }

  public void setStyle(final String style) {
    attributes.set("style", style);
  }

  public void setInteractAttribute(final String name, final String value) {
    ensureInteract();
    interact.setAttribute(name, value);
  }

  public void setInteractOnClick(final String onClick) {
    ensureInteract();
    interact.setOnClick(onClick);
  }

  public void setInteractOnRelease(final String onRelease) {
    ensureInteract();
    interact.setOnRelease(onRelease);
  }

  public void setInteractOnMouseOver(final String onMouseOver) {
    ensureInteract();
    interact.setOnMouseOver(onMouseOver);
  }

  public void setInteractOnClickRepeat(final String onClickRepeat) {
    ensureInteract();
    interact.setOnClickRepeat(onClickRepeat);
  }

  public void setInteractOnClickMouseMove(final String onClickMouseMove) {
    ensureInteract();
    interact.setOnClickMouseMove(onClickMouseMove);
  }

  public void setInteractOnClickAlternateKey(final String onClickAlternateKey) {
    ensureInteract();
    interact.setOnClickAlternateKey(onClickAlternateKey);
  }

  private void ensureInteract() {
    if (interact == null) {
      interact = new ControlInteractAttributes();
    }
  }

  public void setEffectsAttribute(final String name, final String value) {
    ensureEffects();
    effects.setAttribute(name, value);
  }

  public void setEffectsOverlay(final String overlay) {
    ensureEffects();
    effects.setOverlay(overlay);
  }

  public void addEffectsOnStartScreen(final ControlEffectAttributes effectParam) {
    ensureEffects();
    effects.addOnStartScreen(effectParam);
  }

  public void addEffectsOnEndScreen(final ControlEffectAttributes effectParam) {
    ensureEffects();
    effects.addOnEndScreen(effectParam);
  }

  public void addEffectsOnHover(final ControlEffectOnHoverAttributes effectParam) {
    ensureEffects();
    effects.addOnHover(effectParam);
  }

  public void addEffectsOnClick(final ControlEffectAttributes effectParam) {
    ensureEffects();
    effects.addOnClick(effectParam);
  }

  public void addEffectsOnFocus(final ControlEffectAttributes effectParam) {
    ensureEffects();
    effects.addOnFocus(effectParam);
  }

  public void addEffectsOnLostFocus(final ControlEffectAttributes effectParam) {
    ensureEffects();
    effects.addOnLostFocus(effectParam);
  }

  public void addEffectsOnGetFocus(final ControlEffectAttributes effectParam) {
    ensureEffects();
    effects.addOnGetFocus(effectParam);
  }

  public void addEffectsOnActive(final ControlEffectAttributes effectParam) {
    ensureEffects();
    effects.addOnActive(effectParam);
  }

  public void addEffectsOnShow(final ControlEffectAttributes effectParam) {
    ensureEffects();
    effects.addOnShow(effectParam);
  }

  public void addEffectsOnHide(final ControlEffectAttributes effectParam) {
    ensureEffects();
    effects.addOnHide(effectParam);
  }

  public void addEffectsOnCustom(final ControlEffectAttributes effectParam) {
    ensureEffects();
    effects.addOnCustom(effectParam);
  }

  private void ensureEffects() {
    if (effects == null) {
      effects = new ControlEffectsAttributes();
    }
  }

  protected Element createControlInternal(
      final Nifty nifty,
      final Screen screen,
      final Element parent) {
    ControlType controlType = new ControlType(attributes);
    return buildControl(nifty, screen, parent, controlType);
  }

  protected Element createLabel(
      final Nifty nifty,
      final Screen screen,
      final Element parent) {
    LabelType labelType = new LabelType(attributes);
    return buildControl(nifty, screen, parent, labelType);
  }

  protected Element createText(
      final Nifty nifty,
      final Screen screen,
      final Element parent) {
    TextType textType = new TextType(attributes);
    return buildControl(nifty, screen, parent, textType);
  }

  protected Element createPanel(
      final Nifty nifty,
      final Screen screen,
      final Element parent) {
    PanelType panelType = new PanelType(attributes);
    return buildControl(nifty, screen, parent, panelType);
  }

  protected Element createLayer(
      final Nifty nifty,
      final Screen screen,
      final Element parent) {
    LayerType layerType = new LayerType(attributes);
    return buildControl(nifty, screen, parent, layerType);
  }

  protected Element createImage(
      final Nifty nifty,
      final Screen screen,
      final Element parent) {
    ImageType imageType = new ImageType(attributes);
    return buildControl(nifty, screen, parent, imageType);
  }

  private Element buildControl(
      final Nifty nifty,
      final Screen screen,
      final Element parent,
      final ElementType elementType) {
    if (effects != null) {
      elementType.setEffect(effects.create());
    }
    if (interact != null) {
      elementType.setInteract(interact.create());
    }
    elementType.prepare(nifty, parent.getElementType());
    Element element = elementType.create(
      parent,
      nifty,
      screen,
      new LayoutPart());
    screen.layoutLayers();
    return element;
  }

  protected StandardControl getStandardControl() {
    return new StandardControl() {
      public Element createControl(final Nifty nifty, final Screen screen, final Element parent) throws Exception {
        return createControlInternal(nifty, screen, parent);
      }
    };
  }

  public void refreshAttributes(final Attributes attrib) {
    attrib.refreshFromAttributes(attributes);
  }

  public void refreshEffects(final EffectsType effects) {
    if (this.effects != null) {
      effects.refreshFromAttributes(this.effects);
    }
  }
}
