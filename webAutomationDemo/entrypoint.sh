#!/bin/bash

# Start Chrome in headless mode by default
# Accept custom arguments from the container command
google-chrome --headless --disable-gpu --no-sandbox --remote-debugging-port=9222 "$@"

# Keep the container alive for debugging (optional)
# tail -f /dev/null
