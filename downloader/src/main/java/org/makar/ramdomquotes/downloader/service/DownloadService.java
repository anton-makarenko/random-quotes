package org.makar.ramdomquotes.downloader.service;

import java.util.List;

public interface DownloadService<T> {
    List<T> download();
}
