/*
 * Copyright 2016 Game Server Services, Inc. or its affiliates. All Rights
 * Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package io.gs2.cdk.news.model;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.news.resource.*;

import java.util.*;
import java.util.stream.*;

public class News {
	public String section;
	public String content;
	public String title;
	public String scheduleEventId;
	public Long timestamp;
	public String frontMatter;

    public News(
            String section,
            String content,
            String title,
            Long timestamp,
            String frontMatter
    ) {
        this.section = section;
        this.content = content;
        this.title = title;
        this.timestamp = timestamp;
        this.frontMatter = frontMatter;
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.section != null) {
            properties.put("Section", this.section);
        }
        if (this.content != null) {
            properties.put("Content", this.content);
        }
        if (this.title != null) {
            properties.put("Title", this.title);
        }
        if (this.scheduleEventId != null) {
            properties.put("ScheduleEventId", this.scheduleEventId);
        }
        if (this.timestamp != null) {
            properties.put("Timestamp", this.timestamp);
        }
        if (this.frontMatter != null) {
            properties.put("FrontMatter", this.frontMatter);
        }
        return properties;
    }
}
