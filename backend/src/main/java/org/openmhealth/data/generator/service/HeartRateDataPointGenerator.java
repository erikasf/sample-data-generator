/*
 * Copyright 2014 Open mHealth
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

package org.openmhealth.data.generator.service;

import org.openmhealth.data.generator.domain.TimestampedValueGroup;
import org.openmhealth.schema.domain.omh.HeartRate;
import org.springframework.stereotype.Component;

import java.util.Set;

import static java.util.Collections.singleton;


/**
 * @author Emerson Farrugia
 */
@Component
public class HeartRateDataPointGenerator extends AbstractDataPointGeneratorImpl<HeartRate> {

    public static final String RATE_VALUE_KEY = "rate-in-bpm";

    @Override
    public String getName() {
        return "heart-rate";
    }

    @Override
    public Set<String> getRequiredValueKeys() {
        return singleton(RATE_VALUE_KEY);
    }

    @Override
    public Set<String> getSupportedValueKeys() {
        return singleton(RATE_VALUE_KEY);
    }

    @Override
    public HeartRate newMeasure(TimestampedValueGroup valueGroup) {

        return new HeartRate.Builder(valueGroup.getValue(RATE_VALUE_KEY))
                .setEffectiveTimeFrame(valueGroup.getTimestamp())
                .build();
    }
}
