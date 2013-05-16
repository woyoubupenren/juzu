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

package plugin.controller.method.parameters.string.array;

import juzu.Response;
import juzu.View;

import java.io.IOException;
import java.util.Arrays;

/** @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a> */
public class A {

  @View(id = "none")
  public Response.Content none() throws IOException {
    return Response.ok(A_.mv(null).toString());
  }

  @View(id = "0")
  public Response.Content zero() throws IOException {
    return Response.ok(A_.mv(new String[]{}).toString());
  }

  @View(id = "1")
  public Response.Content one() throws IOException {
    return Response.ok(A_.mv(new String[]{"bar"}).toString());
  }

  @View(id = "2")
  public Response.Content two() throws IOException {
    return Response.ok(A_.mv(new String[]{"bar_1", "bar_2"}).toString());
  }

  @View
  public Response.Content mv(String[] foo) throws IOException {
    String s = foo != null ? Arrays.<String>asList((String[])foo).toString() : "";
    return Response.ok(s);
  }
}
