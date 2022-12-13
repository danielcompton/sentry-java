package io.sentry.android.core;

import android.content.Context;
import android.os.Build;
import io.sentry.Integration;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

@ApiStatus.Internal
public final class AnrIntegrationFactory {

  @NotNull
  public static Integration create(final @NotNull Context context,
    final @NotNull BuildInfoProvider buildInfoProvider) {
    if (buildInfoProvider.getSdkInfoVersion() >= Build.VERSION_CODES.R) {
      return new AnrIntegrationV2(context);
    } else {
      return new AnrIntegration(context);
    }
  }
}
