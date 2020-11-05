package com.yumore.resultapis;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author nathaniel
 * @version V1.0.0
 * @package com.yumore.resultapis
 * @datetime 11/5/20 - 11:05 AM
 */
public class CustomActivityResultContract extends ActivityResultContract<String, String> {
    @NonNull
    @Override
    public Intent createIntent(@NonNull Context context, String input) {
        return new Intent(context, SecondActivity.class).putExtra(ContractConstants.CONTRACT_EXTRA_NAME, input);
    }

    @Override
    public String parseResult(int resultCode, @Nullable Intent intent) {
        if (intent == null || resultCode != Activity.RESULT_OK) {
            return null;
        }
        return intent.getStringExtra(ContractConstants.CONTRACT_EXTRA_RESULT);
    }
}
