/*
 * Copyright (c) 2011 Massimiliano Ziccardi
 *  
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */
package it.jnrpe.server;

import it.jnrpe.commands.CommandDefinition;
import it.jnrpe.commands.CommandRepository;
import it.jnrpe.server.CommandsSection.Command;

import java.io.File;

/**
 * Base class for all the JNRPE configuration classes
 * (INI, XML, etc.)
 * @author Massimiliano Ziccardi
 */
public abstract class JNRPEConfiguration
{
    private CommandsSection m_commandSection = new CommandsSection();
    private ServerSection m_serverSection = new ServerSection();
    
    /**
     * All the concrete configuration classes must load
     * the configuration file inside this methos 
     * @param f The configuration file
     * 
     * @throws ConfigurationException on any configuration error.
     */
    public abstract void load(File f) throws ConfigurationException;
    
    /**
     * Returns the command section of the configuration file
     * @return The command section
     */
    public CommandsSection getCommandSection()
    {
        return m_commandSection;
    }
    
    /**
     * Returns the server section of the configuration file
     * @return The server section
     */
    public ServerSection getServerSection()
    {
        return m_serverSection;
    }
    
    /**
     * Returns a command repository containing all the commands configured
     * inside the configuration file
     * @return The command repository
     */
    public CommandRepository createCommandRepository()
    {
        CommandRepository cr = new CommandRepository();
        
        for (Command c : m_commandSection.getAllCommands())
        {
            CommandDefinition cd = new CommandDefinition(c.getName(), c.getPlugin());
            cd.setArgs(c.getCommandLine());
            
            cr.addCommandDefinition(cd);
        }

        return cr;
    }
}
