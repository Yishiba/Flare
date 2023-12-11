package dev.dimension.flare.data.network.mastodon

import dev.dimension.flare.data.network.ktorfit
import dev.dimension.flare.data.network.mastodon.api.JoinMastodonResources

object JoinMastodonService :
    JoinMastodonResources by ktorfit("https://api.joinmastodon.org/").create()
