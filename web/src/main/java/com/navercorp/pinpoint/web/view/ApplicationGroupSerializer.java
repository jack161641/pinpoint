/*
 * Copyright 2014 NAVER Corp.
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

package com.navercorp.pinpoint.web.view;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.navercorp.pinpoint.web.vo.Application;

import java.io.IOException;
import java.util.List;

/**
 * @author emeroad
 */
public class ApplicationGroupSerializer extends JsonSerializer<ApplicationGroup> {

    @Override
    public void serialize(ApplicationGroup applicationGroup, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeStartArray();

        List<Application> applicationList = applicationGroup.getApplicationList();
        for (Application application : applicationList) {
            writeApplication(jgen, application);
        }
        jgen.writeEndArray();
    }

    private void writeApplication(JsonGenerator jgen, Application application) throws IOException {
        jgen.writeStartObject();
        jgen.writeStringField("applicationName", application.getName());
        jgen.writeStringField("serviceType", application.getServiceType().getDesc());
        jgen.writeNumberField("code", application.getServiceTypeCode());
        jgen.writeEndObject();
    }
}
