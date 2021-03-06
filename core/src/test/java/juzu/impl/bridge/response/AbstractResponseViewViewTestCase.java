/*
 * Copyright 2013 eXo Platform SAS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package juzu.impl.bridge.response;

import juzu.impl.common.Tools;
import juzu.test.AbstractWebTestCase;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/** @author <a href="mailto:benjamin.paillereau@exoplatform.com">Benjamin Paillereau</a> */
public abstract class AbstractResponseViewViewTestCase extends AbstractWebTestCase {

  /** . */
  public static String bar;

  @Drone
  WebDriver driver;

  @Test
  public void testPathParam() throws Exception {
    URL url = applicationURL();
    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
    conn.setInstanceFollowRedirects(false);
    conn.connect();
    assertEquals(302, conn.getResponseCode());
    Map<String, String> headers = Tools.responseHeaders(conn);
    String redirect = headers.get("Location");
    bar = null;
    driver.get(redirect);
    assertEquals("bar_value", bar);
  }
}
