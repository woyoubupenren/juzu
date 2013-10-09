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

package juzu.impl.bridge.request;

import juzu.test.AbstractTestCase;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.spec.WebArchive;

/** @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a> */
public class RequestFormParamDefaultEncodingViewServletTestCase extends AbstractRequestFormParamDefaultEncoding {

  @Deployment(testable = false)
  public static WebArchive createDeployment() {
    return createServletDeployment(true, "bridge.request.formparamdefaultencoding.view");
  }

  @Override
  protected void checkEuro(String test) {
    assertNotSame(AbstractTestCase.EURO, test);
  }
}