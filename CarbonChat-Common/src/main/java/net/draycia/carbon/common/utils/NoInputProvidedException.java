// MIT License
//
// Copyright (c) 2020 Alexander Söderberg & Contributors
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.
//
package net.draycia.carbon.common.utils;

import cloud.commandframework.captions.Caption;
import cloud.commandframework.context.CommandContext;
import cloud.commandframework.exceptions.parsing.ParserException;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * An exception which is thrown when an argument's input is unexpectedly null or empty
 */
public class NoInputProvidedException extends ParserException {

  /**
   * Construct a new NoInputProvidedException
   *
   * @param argumentParser Argument parser class
   * @param context        Command context
   */
  public NoInputProvidedException(
    final Class<?> argumentParser,
    final @NonNull CommandContext<?> context
  ) {
    super(
      argumentParser,
      context,
      Caption.of("argument.parse.failure.no_input_was_provided")
    );
  }

}
