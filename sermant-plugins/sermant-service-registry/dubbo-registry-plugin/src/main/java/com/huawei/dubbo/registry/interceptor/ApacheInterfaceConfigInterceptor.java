/*
 * Copyright (C) 2021-2022 Huawei Technologies Co., Ltd. All rights reserved.
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

import com.huawei.dubbo.registry.service.RegistryConfigService;

import com.huaweicloud.sermant.core.plugin.agent.entity.ExecuteContext;
import com.huaweicloud.sermant.core.plugin.agent.interceptor.AbstractInterceptor;
import com.huaweicloud.sermant.core.service.ServiceManager;

/**
 * 增强AbstractInterfaceConfig类的setRegistries/loadRegistriesFromBackwardConfig方法
 *
 * @author provenceee
 * @since 2021-11-08
 */
public class ApacheInterfaceConfigInterceptor extends AbstractInterceptor {
    private final RegistryConfigService registryConfigService;

    /**
     * 构造方法
     */
    public ApacheInterfaceConfigInterceptor() {
        registryConfigService = ServiceManager.getService(RegistryConfigService.class);
    }

    @Override
    public ExecuteContext before(ExecuteContext context) {
        return context;
    }

    @Override
    public ExecuteContext after(ExecuteContext context) {
        registryConfigService.addRegistryConfig(context.getObject());
        return context;
    }
}