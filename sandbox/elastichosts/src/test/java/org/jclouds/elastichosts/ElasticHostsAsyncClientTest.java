/**
 *
 * Copyright (C) 2010 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */

package org.jclouds.elastichosts;

import static org.jclouds.rest.RestContextFactory.contextSpec;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.ws.rs.core.MediaType;

import org.jclouds.elastichosts.domain.CreateDriveRequest;
import org.jclouds.elastichosts.domain.DriveData;
import org.jclouds.elastichosts.domain.ImageConversionType;
import org.jclouds.elastichosts.functions.KeyValuesDelimitedByBlankLinesToDriveInfo;
import org.jclouds.elastichosts.functions.ListOfKeyValuesDelimitedByBlankLinesToDriveInfoSet;
import org.jclouds.elastichosts.functions.ReturnPayload;
import org.jclouds.elastichosts.functions.SplitNewlines;
import org.jclouds.elastichosts.options.ReadDriveOptions;
import org.jclouds.http.HttpRequest;
import org.jclouds.http.filters.BasicAuthentication;
import org.jclouds.http.functions.ReleasePayloadAndReturn;
import org.jclouds.io.Payload;
import org.jclouds.io.Payloads;
import org.jclouds.rest.RestClientTest;
import org.jclouds.rest.RestContextSpec;
import org.jclouds.rest.functions.ReturnNullOnNotFoundOr404;
import org.jclouds.rest.functions.ReturnVoidOnNotFoundOr404;
import org.jclouds.rest.internal.GeneratedHttpRequest;
import org.jclouds.rest.internal.RestAnnotationProcessor;
import org.testng.annotations.Test;

import com.google.common.collect.Iterables;
import com.google.inject.TypeLiteral;

/**
 * Tests annotation parsing of {@code ElasticHostsAsyncClient}
 * 
 * @author Adrian Cole
 */
@Test(groups = "unit", testName = "elastichosts.ElasticHostsAsyncClientTest")
public class ElasticHostsAsyncClientTest extends RestClientTest<ElasticHostsAsyncClient> {

   public void testListDrives() throws SecurityException, NoSuchMethodException, IOException {
      Method method = ElasticHostsAsyncClient.class.getMethod("listDrives");
      GeneratedHttpRequest<ElasticHostsAsyncClient> httpRequest = processor.createRequest(method);

      assertRequestLineEquals(httpRequest, "GET https://api.elastichosts.com/drives/list HTTP/1.1");
      assertNonPayloadHeadersEqual(httpRequest, "Accept: text/plain\n");
      assertPayloadEquals(httpRequest, null, null, false);

      // now make sure request filters apply by replaying
      Iterables.getOnlyElement(httpRequest.getFilters()).filter(httpRequest);
      Iterables.getOnlyElement(httpRequest.getFilters()).filter(httpRequest);

      assertRequestLineEquals(httpRequest, "GET https://api.elastichosts.com/drives/list HTTP/1.1");
      // for example, using basic authentication, we should get "only one"
      // header
      assertNonPayloadHeadersEqual(httpRequest,
            "Accept: text/plain\nAuthorization: Basic aWRlbnRpdHk6Y3JlZGVudGlhbA==\n");
      assertPayloadEquals(httpRequest, null, null, false);

      // TODO: insert expected response class, which probably extends ParseJson
      assertResponseParserClassEquals(method, httpRequest, SplitNewlines.class);
      assertSaxResponseParserClassEquals(method, null);
      assertExceptionParserClassEquals(method, null);

      checkFilters(httpRequest);

   }

   public void testListStandardDrives() throws SecurityException, NoSuchMethodException, IOException {
      Method method = ElasticHostsAsyncClient.class.getMethod("listStandardDrives");
      GeneratedHttpRequest<ElasticHostsAsyncClient> httpRequest = processor.createRequest(method);

      assertRequestLineEquals(httpRequest, "GET https://api.elastichosts.com/drives/standard/list HTTP/1.1");
      assertNonPayloadHeadersEqual(httpRequest, "Accept: text/plain\n");
      assertPayloadEquals(httpRequest, null, null, false);

      assertResponseParserClassEquals(method, httpRequest, SplitNewlines.class);
      assertSaxResponseParserClassEquals(method, null);
      assertExceptionParserClassEquals(method, null);

      checkFilters(httpRequest);
   }

   public void testListStandardCds() throws SecurityException, NoSuchMethodException, IOException {
      Method method = ElasticHostsAsyncClient.class.getMethod("listStandardCds");
      GeneratedHttpRequest<ElasticHostsAsyncClient> httpRequest = processor.createRequest(method);

      assertRequestLineEquals(httpRequest, "GET https://api.elastichosts.com/drives/standard/cd/list HTTP/1.1");
      assertNonPayloadHeadersEqual(httpRequest, "Accept: text/plain\n");
      assertPayloadEquals(httpRequest, null, null, false);

      assertResponseParserClassEquals(method, httpRequest, SplitNewlines.class);
      assertSaxResponseParserClassEquals(method, null);
      assertExceptionParserClassEquals(method, null);

      checkFilters(httpRequest);
   }

   public void testListStandardImages() throws SecurityException, NoSuchMethodException, IOException {
      Method method = ElasticHostsAsyncClient.class.getMethod("listStandardImages");
      GeneratedHttpRequest<ElasticHostsAsyncClient> httpRequest = processor.createRequest(method);

      assertRequestLineEquals(httpRequest, "GET https://api.elastichosts.com/drives/standard/img/list HTTP/1.1");
      assertNonPayloadHeadersEqual(httpRequest, "Accept: text/plain\n");
      assertPayloadEquals(httpRequest, null, null, false);

      assertResponseParserClassEquals(method, httpRequest, SplitNewlines.class);
      assertSaxResponseParserClassEquals(method, null);
      assertExceptionParserClassEquals(method, null);

      checkFilters(httpRequest);
   }

   public void testListDriveInfo() throws SecurityException, NoSuchMethodException, IOException {
      Method method = ElasticHostsAsyncClient.class.getMethod("listDriveInfo");
      GeneratedHttpRequest<ElasticHostsAsyncClient> httpRequest = processor.createRequest(method);

      assertRequestLineEquals(httpRequest, "GET https://api.elastichosts.com/drives/info HTTP/1.1");
      assertNonPayloadHeadersEqual(httpRequest, "Accept: text/plain\n");
      assertPayloadEquals(httpRequest, null, null, false);

      assertResponseParserClassEquals(method, httpRequest, ListOfKeyValuesDelimitedByBlankLinesToDriveInfoSet.class);
      assertSaxResponseParserClassEquals(method, null);
      assertExceptionParserClassEquals(method, null);

      checkFilters(httpRequest);
   }

   public void testGetDriveInfo() throws SecurityException, NoSuchMethodException, IOException {
      Method method = ElasticHostsAsyncClient.class.getMethod("getDriveInfo", String.class);
      GeneratedHttpRequest<ElasticHostsAsyncClient> httpRequest = processor.createRequest(method, "uuid");

      assertRequestLineEquals(httpRequest, "GET https://api.elastichosts.com/drives/uuid/info HTTP/1.1");
      assertNonPayloadHeadersEqual(httpRequest, "Accept: text/plain\n");
      assertPayloadEquals(httpRequest, null, null, false);

      assertResponseParserClassEquals(method, httpRequest, KeyValuesDelimitedByBlankLinesToDriveInfo.class);
      assertSaxResponseParserClassEquals(method, null);
      assertExceptionParserClassEquals(method, ReturnNullOnNotFoundOr404.class);

      checkFilters(httpRequest);

   }

   public void testCreateDrive() throws SecurityException, NoSuchMethodException, IOException {
      Method method = ElasticHostsAsyncClient.class.getMethod("createDrive", CreateDriveRequest.class);
      GeneratedHttpRequest<ElasticHostsAsyncClient> httpRequest = processor.createRequest(method,
            new CreateDriveRequest.Builder().name("foo").size(10000l).build());

      assertRequestLineEquals(httpRequest, "POST https://api.elastichosts.com/drives/create HTTP/1.1");
      assertNonPayloadHeadersEqual(httpRequest, "Accept: text/plain\n");
      assertPayloadEquals(httpRequest, "name foo\nsize 10000", "text/plain", false);

      assertResponseParserClassEquals(method, httpRequest, KeyValuesDelimitedByBlankLinesToDriveInfo.class);
      assertSaxResponseParserClassEquals(method, null);
      assertExceptionParserClassEquals(method, ReturnNullOnNotFoundOr404.class);

      checkFilters(httpRequest);

   }

   public void testSetDriveData() throws SecurityException, NoSuchMethodException, IOException {
      Method method = ElasticHostsAsyncClient.class.getMethod("setDriveData", String.class, DriveData.class);
      GeneratedHttpRequest<ElasticHostsAsyncClient> httpRequest = processor.createRequest(method, "100",
            new DriveData.Builder().name("foo").size(10000l).build());

      assertRequestLineEquals(httpRequest, "POST https://api.elastichosts.com/drives/100/set HTTP/1.1");
      assertNonPayloadHeadersEqual(httpRequest, "Accept: text/plain\n");
      assertPayloadEquals(httpRequest, "name foo\nsize 10000", "text/plain", false);

      assertResponseParserClassEquals(method, httpRequest, KeyValuesDelimitedByBlankLinesToDriveInfo.class);
      assertSaxResponseParserClassEquals(method, null);
      assertExceptionParserClassEquals(method, ReturnNullOnNotFoundOr404.class);

      checkFilters(httpRequest);

   }

   public void testImageDrive() throws SecurityException, NoSuchMethodException, IOException {
      Method method = ElasticHostsAsyncClient.class.getMethod("imageDrive", String.class, String.class);
      GeneratedHttpRequest<ElasticHostsAsyncClient> httpRequest = processor.createRequest(method, "100", "200");

      assertRequestLineEquals(httpRequest, "POST https://api.elastichosts.com/drives/200/image/100 HTTP/1.1");
      assertNonPayloadHeadersEqual(httpRequest, "Accept: text/plain\n");
      assertPayloadEquals(httpRequest, null, null, false);

      assertResponseParserClassEquals(method, httpRequest, ReleasePayloadAndReturn.class);
      assertSaxResponseParserClassEquals(method, null);
      assertExceptionParserClassEquals(method, ReturnVoidOnNotFoundOr404.class);

      checkFilters(httpRequest);

   }

   public void testImageDriveWithConversion() throws SecurityException, NoSuchMethodException, IOException {
      Method method = ElasticHostsAsyncClient.class.getMethod("imageDrive", String.class, String.class,
            ImageConversionType.class);
      GeneratedHttpRequest<ElasticHostsAsyncClient> httpRequest = processor.createRequest(method, "100", "200",
            ImageConversionType.GUNZIP);

      assertRequestLineEquals(httpRequest, "POST https://api.elastichosts.com/drives/200/image/100/gunzip HTTP/1.1");
      assertNonPayloadHeadersEqual(httpRequest, "Accept: text/plain\n");
      assertPayloadEquals(httpRequest, null, null, false);

      assertResponseParserClassEquals(method, httpRequest, ReleasePayloadAndReturn.class);
      assertSaxResponseParserClassEquals(method, null);
      assertExceptionParserClassEquals(method, ReturnVoidOnNotFoundOr404.class);

      checkFilters(httpRequest);

   }

   public void testDestroyDrive() throws SecurityException, NoSuchMethodException, IOException {
      Method method = ElasticHostsAsyncClient.class.getMethod("destroyDrive", String.class);
      GeneratedHttpRequest<ElasticHostsAsyncClient> httpRequest = processor.createRequest(method, "uuid");

      assertRequestLineEquals(httpRequest, "POST https://api.elastichosts.com/drives/uuid/destroy HTTP/1.1");
      assertNonPayloadHeadersEqual(httpRequest, "Accept: text/plain\n");
      assertPayloadEquals(httpRequest, null, null, false);

      assertResponseParserClassEquals(method, httpRequest, ReleasePayloadAndReturn.class);
      assertSaxResponseParserClassEquals(method, null);
      assertExceptionParserClassEquals(method, ReturnVoidOnNotFoundOr404.class);

      checkFilters(httpRequest);

   }

   public void testReadDrive() throws SecurityException, NoSuchMethodException, IOException {
      Method method = ElasticHostsAsyncClient.class.getMethod("readDrive", String.class);
      GeneratedHttpRequest<ElasticHostsAsyncClient> httpRequest = processor.createRequest(method, "100");

      assertRequestLineEquals(httpRequest, "GET https://api.elastichosts.com/drives/100/read HTTP/1.1");
      assertNonPayloadHeadersEqual(httpRequest, "Accept: application/octet-stream\n");
      assertPayloadEquals(httpRequest, null, null, false);

      assertResponseParserClassEquals(method, httpRequest, ReturnPayload.class);
      assertSaxResponseParserClassEquals(method, null);
      assertExceptionParserClassEquals(method, ReturnNullOnNotFoundOr404.class);

      checkFilters(httpRequest);
   }

   public void testReadDriveOptions() throws SecurityException, NoSuchMethodException, IOException {
      Method method = ElasticHostsAsyncClient.class.getMethod("readDrive", String.class, ReadDriveOptions.class);
      GeneratedHttpRequest<ElasticHostsAsyncClient> httpRequest = processor.createRequest(method, "100",
            new ReadDriveOptions().offset(1024).size(2048));

      assertRequestLineEquals(httpRequest, "POST https://api.elastichosts.com/drives/100/read/1024/2048 HTTP/1.1");
      assertNonPayloadHeadersEqual(httpRequest, "Accept: application/octet-stream\n");
      assertPayloadEquals(httpRequest, null, null, false);

      assertResponseParserClassEquals(method, httpRequest, ReturnPayload.class);
      assertSaxResponseParserClassEquals(method, null);
      assertExceptionParserClassEquals(method, ReturnNullOnNotFoundOr404.class);

      checkFilters(httpRequest);
   }

   public void testWriteDrive() throws SecurityException, NoSuchMethodException, IOException {
      Method method = ElasticHostsAsyncClient.class.getMethod("writeDrive", String.class, Payload.class);
      GeneratedHttpRequest<ElasticHostsAsyncClient> httpRequest = processor.createRequest(method, "100",
            Payloads.newStringPayload("foo"));

      assertRequestLineEquals(httpRequest, "POST https://api.elastichosts.com/drives/100/write HTTP/1.1");
      assertNonPayloadHeadersEqual(httpRequest, "Accept: text/plain\n");
      assertPayloadEquals(httpRequest, "", MediaType.APPLICATION_OCTET_STREAM, false);

      assertResponseParserClassEquals(method, httpRequest, ReleasePayloadAndReturn.class);
      assertSaxResponseParserClassEquals(method, null);
      assertExceptionParserClassEquals(method, ReturnVoidOnNotFoundOr404.class);

      checkFilters(httpRequest);
   }

   public void testWriteDriveOffset() throws SecurityException, NoSuchMethodException, IOException {
      Method method = ElasticHostsAsyncClient.class.getMethod("writeDrive", String.class, Payload.class, long.class);
      GeneratedHttpRequest<ElasticHostsAsyncClient> httpRequest = processor.createRequest(method, "100",
            Payloads.newStringPayload("foo"), 2048);

      assertRequestLineEquals(httpRequest, "POST https://api.elastichosts.com/drives/100/write/2048 HTTP/1.1");
      assertNonPayloadHeadersEqual(httpRequest, "Accept: text/plain\n");
      assertPayloadEquals(httpRequest, "", MediaType.APPLICATION_OCTET_STREAM, false);

      assertResponseParserClassEquals(method, httpRequest, ReleasePayloadAndReturn.class);
      assertSaxResponseParserClassEquals(method, null);
      assertExceptionParserClassEquals(method, ReturnVoidOnNotFoundOr404.class);

      checkFilters(httpRequest);
   }

   @Override
   protected void checkFilters(HttpRequest request) {
      assertEquals(request.getFilters().size(), 1);
      assertEquals(request.getFilters().get(0).getClass(), BasicAuthentication.class);
   }

   @Override
   protected TypeLiteral<RestAnnotationProcessor<ElasticHostsAsyncClient>> createTypeLiteral() {
      return new TypeLiteral<RestAnnotationProcessor<ElasticHostsAsyncClient>>() {
      };
   }

   @Override
   public RestContextSpec<ElasticHostsClient, ElasticHostsAsyncClient> createContextSpec() {
      return contextSpec("elastichosts", "https://api.elastichosts.com", "1.0", "identity", "credential",
            ElasticHostsClient.class, ElasticHostsAsyncClient.class);
   }
}
