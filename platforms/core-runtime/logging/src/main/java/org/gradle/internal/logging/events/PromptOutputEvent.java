/*
 * Copyright 2017 the original author or authors.
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

package org.gradle.internal.logging.events;

import org.gradle.api.logging.LogLevel;
import org.gradle.internal.Either;
import org.gradle.internal.logging.text.StyledTextOutput;
import org.gradle.internal.operations.OperationIdentifier;

/**
 * Requests that the client present the given prompt to the user and return the user's response as a single line of text.
 *
 * The response is delivered to the {@link UserInputReader} service.
 */
public abstract class PromptOutputEvent extends RenderableOutputEvent implements InteractiveEvent {
    private final String prompt;

    public PromptOutputEvent(long timestamp, String prompt) {
        super(timestamp, "prompt", LogLevel.QUIET, null);
        this.prompt = prompt;
    }

    @Override
    public void render(StyledTextOutput output) {
        // Add a newline at the start of each question
        output.println();
        output.text(prompt);
    }

    /**
     * Converts the given text into the response object, or returns a new prompt to display to the user.
     */
    public Either<?, String> convert(String text) {
        return Either.left(text);
    }

    public String getPrompt() {
        return prompt;
    }

    @Override
    public String toString() {
        return "[" + getLogLevel() + "] [" + getCategory() + "] '" + prompt + "'";
    }

    @Override
    public RenderableOutputEvent withBuildOperationId(OperationIdentifier buildOperationId) {
        throw new UnsupportedOperationException();
    }
}
