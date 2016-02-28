/*
 * Copyright (c) 2015, Nifty GUI Community 
 * All rights reserved. 
 * 
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are 
 * met: 
 * 
 *  * Redistributions of source code must retain the above copyright 
 *    notice, this list of conditions and the following disclaimer. 
 *  * Redistributions in binary form must reproduce the above copyright 
 *    notice, this list of conditions and the following disclaimer in the 
 *    documentation and/or other materials provided with the distribution. 
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS ``AS IS'' AND 
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR 
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF 
 * THE POSSIBILITY OF SUCH DAMAGE.
 */
package de.lessvoid.niftyinternal.canvas.path;

import de.lessvoid.nifty.NiftyRuntimeException;
import de.lessvoid.niftyinternal.canvas.LineParameters;
import de.lessvoid.niftyinternal.canvas.path.CubicBezier.Renderer;
import de.lessvoid.niftyinternal.math.Mat4;
import de.lessvoid.niftyinternal.math.Vec2;
import de.lessvoid.niftyinternal.render.batch.BatchManager;

public class PathElementCubicBezier implements PathElement {
  private final float cp1x;
  private final float cp1y;
  private final float cp2x;
  private final float cp2y;
  private final float x;
  private final float y;
  private final boolean startNewLine;
  private Vec2 pathLastPoint;

  public PathElementCubicBezier(
      final float cp1x,
      final float cp1y,
      final float cp2x,
      final float cp2y,
      final float x,
      final float y,
      final boolean startNewLine) {
    this.cp1x = cp1x;
    this.cp1y = cp1y;
    this.cp2x = cp2x;
    this.cp2y = cp2y;
    this.x = x;
    this.y = y;
    this.startNewLine = startNewLine;
  }

  @Override
  public Vec2 getPathPoint(final Vec2 pathLastPoint) {
    if (this.startNewLine) {
      if (pathLastPoint == null) {
        throw new NiftyRuntimeException("lineTo with startNewLine (preceding element is moveTo) but no pathLastPoint");
      }
      this.pathLastPoint = new Vec2(pathLastPoint);
    }
    return new Vec2(x, y);
  }

  @Override
  public void stroke(final LineParameters lineParameters, final Mat4 transform, final BatchManager batchManager) {
    if (startNewLine) {
      batchManager.addFirstLineVertex(pathLastPoint.getX(), pathLastPoint.getY(), transform, lineParameters);
    }

    CubicBezier curve = new CubicBezier(
        pathLastPoint,
        new Vec2(cp1x, cp1y),
        new Vec2(cp2x, cp2y),
        new Vec2(x, y));
    curve.renderCurve(new Renderer() {
      @Override
      public void addLineVertex(float x, float y) {
        batchManager.addLineVertex(x, y, transform, lineParameters);
      }
    });
  }

  @Override
  public void fill(final Mat4 transform, final BatchManager batchManager) {
    // TODO
  }
}