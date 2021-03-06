package net.draycia.carbon.api.config;

import net.draycia.carbon.api.adventure.FormatType;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.ObjectMapper;
import org.spongepowered.configurate.objectmapping.meta.Comment;
import org.spongepowered.configurate.objectmapping.meta.Setting;
import org.spongepowered.configurate.serialize.SerializationException;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

@ConfigSerializable
public final class CarbonSettings {

  private static final ObjectMapper<CarbonSettings> MAPPER;

  static {
    try {
      MAPPER = ObjectMapper.factory().get(CarbonSettings.class);
    } catch (final SerializationException e) {
      throw new ExceptionInInitializerError(e);
    }
  }

  public static CarbonSettings loadFrom(final CommentedConfigurationNode node) throws SerializationException {
    return MAPPER.load(node);
  }

  public void saveTo(final CommentedConfigurationNode node) throws SerializationException {
    MAPPER.save(this, node);
  }

  @Setting
  @Comment("The prefix shown when spying on a user's message")
  private @NonNull String spyPrefix = "<color>[SPY] ";

  @Setting
  @Comment("Used for <server> placeholder in channel formats")
  private @NonNull String serverName = "Server";

  @Setting
  @Comment("Set this to false to disable warnings and tips when the plugin thinks there may be configuration issues.")
  private boolean showTips = true;

  @Setting
  @Comment("Options: JSON, MYSQL")
  private @Nullable StorageType storageType = StorageType.JSON;

  @Setting
  @Comment("The credentials used to connect to your database. Requires storageType=MYSQL")
  private @NonNull SQLCredentials sqlCredentials = new SQLCredentials();

  @Setting
  @Comment("Options: NONE, REDIS, BUNGEECORD\n" +
    " 'BUNGEECORD' - Uses bungee plugin messaging, requires BungeeCord or another proxy which supports it (Velocity, Waterfall!)\n" +
    " 'REDIS' - Uses redis for cross server syncing, does not require a server proxy\n" +
    " 'NONE' - Do not sync anything cross server, this is the default\n" +
    "Note: In order for channels to sync cross server, you'll need to enable is-cross-server for the\n" +
    "   channel as well as this setting.")
  private @NonNull MessagingType messagingType = MessagingType.NONE;

  @Setting
  @Comment("Options: MOJANG, MINIMESSAGE_MARKDOWN, MINIMESSAGE, MINEDOWN")
  private @NonNull FormatType formatType = FormatType.MINIMESSAGE;

  @Setting
  @Comment("The credentials necessary to connect to your redis server")
  private @NonNull RedisCredentials redisCredentials = new RedisCredentials();

  @Setting
  @Comment("Plays a sound and highlights the message when someone types your name")
  private @NonNull ChannelPings channelPings = new ChannelPings();

  @Setting
  @Comment("Various options relating to the /whisper command")
  private @NonNull WhisperOptions whisperOptions = new WhisperOptions();

  @Setting
  @Comment("Sets the player's channel to the specified channel when they join" +
    "\nSet to \"\" or remove to disable" +
    "\nSet to DEFAULT to set the player's channel to the default channel on join" +
    "\nOtherwise, set to a channel to set the player's channel to it on join" +
    "\nFor example, channel-on-join: \"global\" sets their channel to global on join")
  private @Nullable String channelOnJoin = "";

  @Setting
  @Comment("The list of regex patterns to show items in chat. '\\\\Q' and '\\\\E' just denote that the content isn't regex.")
  private List<Pattern> itemLinkPatterns =
    Collections.singletonList(Pattern.compile(Pattern.quote("[item]")));

  public @NonNull List<@NonNull Pattern> itemLinkPatterns() {
    return this.itemLinkPatterns;
  }

  public @NonNull String spyPrefix() {
    return this.spyPrefix;
  }

  public @NonNull String serverName() {
    return this.serverName;
  }

  public boolean showTips() {
    return this.showTips;
  }

  public @Nullable StorageType storageType() {
    return this.storageType;
  }

  public SQLCredentials sqlCredentials() {
    return this.sqlCredentials;
  }

  public @NonNull MessagingType messagingType() {
    return this.messagingType;
  }

  public @NonNull RedisCredentials redisCredentials() {
    return this.redisCredentials;
  }

  public @Nullable String channelOnJoin() {
    return this.channelOnJoin;
  }

  public @NonNull ChannelPings channelPings() {
    return this.channelPings;
  }

  public @NonNull WhisperOptions whisperOptions() {
    return this.whisperOptions;
  }

  public @NonNull FormatType formatType() {
    return this.formatType;
  }
}
