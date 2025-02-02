/*
 * Copyright (C) 2022-2022 Huawei Technologies Co., Ltd. All rights reserved.
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

package com.huawei.dubbo.registry.interceptor;

import com.huawei.dubbo.registry.constants.Constant;
import com.huawei.dubbo.registry.utils.CollectionUtils;

import com.huaweicloud.sermant.core.plugin.agent.entity.ExecuteContext;
import com.huaweicloud.sermant.core.plugin.agent.interceptor.AbstractInterceptor;

import org.apache.dubbo.common.URL;

/**
 * Enhance the extractRegistryType method of the ConfigValidation Utils class
 *
 * @author provenceee
 * @since 2022-01-27
 */
public class ConfigValidationInterceptor extends AbstractInterceptor {
    private static final String REGISTRY_TYPE_KEY_1 = "registry-type";

    private static final String REGISTRY_TYPE_KEY_2 = "registry.type";

    @Override
    public ExecuteContext before(ExecuteContext context) {
        Object[] arguments = context.getArguments();
        if (arguments[0] instanceof URL) {
            URL url = (URL) arguments[0];

            // This interception point is to block the SC application-level registration of 2.7.5-2.7.8
            if (Constant.SC_REGISTRY_PROTOCOL.equals(url.getProtocol())
                    && !CollectionUtils.isEmpty(url.getParameters())) {
                if (url.hasParameter(REGISTRY_TYPE_KEY_1) || url.hasParameter(REGISTRY_TYPE_KEY_2)) {
                    arguments[0] = url.removeParameters(REGISTRY_TYPE_KEY_1, REGISTRY_TYPE_KEY_2);
                }
            }
        }
        return context;
    }

    @Override
    public ExecuteContext after(ExecuteContext context) {
        return context;
    }
}
