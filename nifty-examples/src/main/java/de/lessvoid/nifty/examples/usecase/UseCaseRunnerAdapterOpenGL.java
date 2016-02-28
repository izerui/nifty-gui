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
package de.lessvoid.nifty.examples.usecase;

import com.lessvoid.coregl.spi.CoreGL;
import com.lessvoid.coregl.spi.CoreSetup;
import com.lessvoid.coregl.spi.CoreSetup.RenderLoopCallback;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyCallback;
import de.lessvoid.nifty.NiftyConfiguration;
import de.lessvoid.nifty.input.lwjgl.NiftyInputDeviceLWJGL;
import de.lessvoid.nifty.renderer.opengl.NiftyRenderDeviceOpenGL;
import de.lessvoid.nifty.spi.NiftyInputDevice;
import de.lessvoid.nifty.time.AccurateTimeProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static de.lessvoid.nifty.Nifty.createNifty;

/**
 * UseCaseRunnerAdapter for CoreGL based NiftyRenderDevice. This supports both
 * LWJGL and JOGL through the CoreGL project.
 *
 * @author void
 */
public class UseCaseRunnerAdapterOpenGL implements UseCaseRunnerAdapter {
  private static Logger log = LoggerFactory.getLogger(UseCaseRunnerAdapterOpenGL.class.getName());
  private CoreSetup setup;
  private CoreGL coreGL;

  public UseCaseRunnerAdapterOpenGL(final CoreSetup setup, final CoreGL coreGL) {
    this.setup = setup;
    this.coreGL = coreGL;
  }

  @Override
  public void run(final Class<?> useCaseClass, final String[] args, final NiftyConfiguration niftyConfiguration) throws Exception {
    setup.initialize(caption(useCaseClass.getSimpleName()), 1024, 768);
    setup.enableVSync(false);

    // create nifty instance
    final Nifty nifty = createNifty(createRenderDevice(), createInputDevice(), new AccurateTimeProvider(), niftyConfiguration);
    final Object useCase = useCaseClass.getConstructor(Nifty.class).newInstance(nifty);
    nifty.update();
    logScene(nifty);

    nifty.startAnimatedThreaded(0, 1000, new NiftyCallback<Float>() {
      private final List<String> data = new ArrayList<>();

      @Override
      public void execute(final Float aFloat) {
        nifty.getStatistics().getStatistics(data);
        for (int i=0; i<data.size(); i++) {
          System.out.print(data.get(i));
        }
      }
    });


    setup.renderLoop(new RenderLoopCallback() {

      @Override
      public void init(final CoreGL gl) {
      }

      @Override
      public boolean render(final CoreGL gl, final float deltaTime) {
        nifty.update();
        return nifty.render();
      }

      @Override
      public boolean endLoop() {
        return false;
      }
    });
  }

  private String caption(final String caption) {
    return "Nifty 2.0 (" + caption + ")";
  }

  private void logScene(final Nifty nifty) {
    log.info(nifty.getSceneInfoLog());
  }

  private NiftyRenderDeviceOpenGL createRenderDevice() throws Exception {
    return new NiftyRenderDeviceOpenGL(coreGL);
  }

  private NiftyInputDevice createInputDevice() throws Exception {
    return new NiftyInputDeviceLWJGL();
  }
}