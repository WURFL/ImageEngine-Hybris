package com.imageengine.media.url.impl;

import de.hybris.platform.media.MediaSource;
import de.hybris.platform.media.storage.MediaStorageConfigService;
import de.hybris.platform.media.url.impl.LocalMediaWebURLStrategy;
import de.hybris.platform.util.Config;
import de.hybris.platform.util.MediaUtil;


public class ImageEngineUrlStrategy extends LocalMediaWebURLStrategy
{
	final String mediaHostName = Config.getString("media.folder.images.hostname", "");

	@Override
	public String getUrlForMedia(final MediaStorageConfigService.MediaFolderConfig config, final MediaSource mediaSource)
	{
		final String urlForMedia = super.getUrlForMedia(config, mediaSource);
		return appandHostName(urlForMedia);
	}

	@Override
	public String getDownloadUrlForMedia(final MediaStorageConfigService.MediaFolderConfig config, final MediaSource mediaSource)
	{
		final String downloadUrlForMedia = super.getDownloadUrlForMedia(config, mediaSource);
		return appandHostName(downloadUrlForMedia);
	}

	private String appandHostName(final String urlForMedia)
	{
		if (!mediaHostName.isEmpty())
		{
			return MediaUtil.removeTrailingFileSepIfNeeded(mediaHostName) + urlForMedia;
		}
		return urlForMedia;
	}
}
