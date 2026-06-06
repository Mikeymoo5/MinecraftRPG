package dev.mikeymoo5.minecraftRPG.stats;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.mikeymoo5.minecraftRPG.MinecraftRPG;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StatManager {
    private final MinecraftRPG plugin;
    private final Map<UUID, PlayerProfile> profiles = new HashMap<>();

    public StatManager(MinecraftRPG plugin) {
        this.plugin = plugin;
    }
    // TODO: Add a save all method

    // TODO: If player does not have save data, create a new player profile
    public void loadProfile(Player player) {

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            PlayerProfile loadedProfile;

            File file = new File(plugin.getDataFolder(), "players/" + player.getUniqueId() + ".json");
            if(!file.exists()) {
                Bukkit.getLogger().info("Creating new PlayerProfile for UUID: " + player.getUniqueId());
                loadedProfile = new PlayerProfile(player.getUniqueId());
            } else {
                try (FileReader fileReader = new FileReader(file)) {
                    Gson gson = new Gson();
                    loadedProfile = gson.fromJson(fileReader, PlayerProfile.class);
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            }
            Bukkit.getScheduler().runTask(plugin, () -> {
                addProfile(player.getUniqueId(), loadedProfile);
            });
        });
    }

    // Save player data and remove from hash map
    public void saveProfile(Player player) {
        PlayerProfile profile = getProfile(player);

        plugin.getDataFolder().mkdirs();
        File file = new File(plugin.getDataFolder(), "players/" + player.getUniqueId() + ".json");
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) parent.mkdirs();

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            try(FileWriter writer = new FileWriter(file)) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(profile, writer);
            } catch (IOException e){
                e.printStackTrace();;
            }
        });

    }
    public PlayerProfile getProfile(Player player) {
        return profiles.get(player.getUniqueId());
    }

    private void removeProfile(UUID uuid) {
        profiles.remove(uuid);
    }
    private void addProfile(UUID uuid, PlayerProfile profile) {
        if (profile == null) {
            throw new IllegalArgumentException("Profile cannot be null");
        }
        if (profiles.containsKey(uuid)) {
            return;
        }

        this.profiles.put(uuid, profile);
    }

    public void removeProfileByPlayer(Player player) {
        profiles.remove(player.getUniqueId());
    }
}
