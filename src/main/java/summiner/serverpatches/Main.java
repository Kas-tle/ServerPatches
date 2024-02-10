package summiner.serverpatches;

import org.bstats.bukkit.Metrics;
import summiner.serverpatches.Utils.Command;
import summiner.serverpatches.Utils.Manager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static FileConfiguration config;
    public static Manager manager;

    public static void logMessage(String msg) {
        Main.getPlugin(Main.class).getLogger().info(msg);
    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        config = this.getConfig();
        manager = new Manager();
        manager.reload();
        this.getCommand("spatches").setExecutor(new Command());
        Metrics metrics = new Metrics(this, 20975);
        logMessage("Loaded Plugin (Spigot)");
    }

    @Override
    public void onDisable() {
        manager.unload();
    }
}