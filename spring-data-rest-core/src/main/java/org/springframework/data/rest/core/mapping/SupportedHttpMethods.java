/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.rest.core.mapping;

import java.util.Collections;
import java.util.Set;

import org.springframework.http.HttpMethod;

/**
 * An API to discover the {@link HttpMethod}s supported on a given {@link ResourceType}.
 * 
 * @author Oliver Gierke
 */
public interface SupportedHttpMethods {

	/**
	 * Returns whether the given {@link HttpMethod} is supported for the given {@link ResourceType}.
	 * 
	 * @param httpMethod must not be {@literal null}.
	 * @param resourceType must not be {@literal null}.
	 * @return
	 */
	boolean supports(HttpMethod method, ResourceType type);

	/**
	 * Returns the supported {@link HttpMethod}s for the given {@link ResourceType}.
	 * 
	 * @param resourcType must not be {@literal null}.
	 * @return
	 */
	Set<HttpMethod> getMethodsFor(ResourceType resourcType);

	/**
	 * Null object to abstract the absence of any support for any HTTP method.
	 *
	 * @author Oliver Gierke
	 */
	enum NoSupportedMethods implements SupportedHttpMethods {

		INSTANCE;

		/* 
		 * (non-Javadoc)
		 * @see org.springframework.data.rest.core.mapping.SupportedHttpMethods#getSupportedHttpMethods(org.springframework.data.rest.core.mapping.ResourceType)
		 */
		@Override
		public Set<HttpMethod> getMethodsFor(ResourceType resourcType) {
			return Collections.emptySet();
		}

		/* 
		 * (non-Javadoc)
		 * @see org.springframework.data.rest.core.mapping.SupportedHttpMethods#supports(org.springframework.http.HttpMethod, org.springframework.data.rest.core.mapping.ResourceType)
		 */
		@Override
		public boolean supports(HttpMethod method, ResourceType type) {
			return false;
		}
	}
}
