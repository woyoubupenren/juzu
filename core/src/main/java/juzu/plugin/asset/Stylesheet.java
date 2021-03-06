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

package juzu.plugin.asset;

import juzu.asset.AssetLocation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A stylesheet asset declaration.
 *
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface Stylesheet {

  /**
   * @return the asset id, used for referencing this stylesheet, the value is optional.
   */
  String id() default "";

  /**
   * @return the value for resolving the stylesheet
   */
  String value();

  /**
   * @return the minified version of the stylesheet
   */
  String minified() default "";

  /**
   * @return the stylesheet dependencies, i.e the stylesheet that are needed by this stylesheet.
   */
  String[] depends() default {};

  /**
   * @return the asset location
   */
  AssetLocation location() default AssetLocation.APPLICATION;

  /**
   * Defines <code>max-age</code> cache control headers for this stylesheet asset.
   *
   * @return the max age
   */
  int maxAge() default -1;

  /**
   * @return the list of minifiers for this stylesheet asset.
   */
  Class<? extends Minifier>[] minifier() default {};
}
