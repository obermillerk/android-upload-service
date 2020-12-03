package com.example.uploadservice.s3

import android.os.Parcelable
import com.amazonaws.regions.Regions
import kotlinx.android.parcel.Parcelize
import net.gotev.uploadservice.persistence.Persistable
import net.gotev.uploadservice.persistence.PersistableData

@Parcelize
data class S3UploadTaskParameters (
        var serverSubpath: String = "",
        var bucketName: String,
        var identityPoolId: String,
        var region: String = Regions.US_EAST_1.name,
        var bucketKey: String = "com.aws.s3$bucketName",
        var identityKey: String = "com.aws.s3$identityPoolId",
        ) : Parcelable, Persistable {
    companion object : Persistable.Creator<S3UploadTaskParameters> {
        /**
         * The default FTP connection timeout in milliseconds.
         */

        private object CodingKeys {
            const val serverSubpath = "serverSubpath"
            const val bucketName = "bucketName"
            const val identityPoolId = "identityPoolId"
            const val region = "region"
            const val bucketKey = "bucketKey"
            const val identityKey = "identityKey"
        }

        override fun createFromPersistableData(data: PersistableData) = S3UploadTaskParameters(
                serverSubpath = data.getString(CodingKeys.serverSubpath),
                bucketName = data.getString(CodingKeys.bucketName),
                identityPoolId = data.getString(CodingKeys.identityPoolId),
                region = data.getString(CodingKeys.region),
                bucketKey = data.getString(CodingKeys.bucketKey),
                identityKey = data.getString(CodingKeys.identityKey),
        )
    }

    override fun toPersistableData() = PersistableData().apply {
        putString(CodingKeys.serverSubpath, serverSubpath)
        putString(CodingKeys.bucketName, bucketName)
        putString(CodingKeys.identityPoolId, identityPoolId)
        putString(CodingKeys.region, region)
        putString(CodingKeys.bucketKey, bucketKey)
        putString(CodingKeys.identityKey, identityKey)
    }
}