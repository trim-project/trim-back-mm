package trim.api.common.util;

import org.springframework.data.domain.Sort;

public class PageUtil {
    public final static Sort LATEST_SORTING = Sort.by("createdAt").descending();
}
