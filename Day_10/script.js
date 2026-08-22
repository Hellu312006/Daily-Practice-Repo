/*
================================================================
   Interactive DSA Visualizer - JS Script (Day 10)
   Features: Async generators for smooth visual debugging
================================================================
*/

// Application State
const state = {
    category: 'sorting', // sorting, searching, stack, queue
    algorithm: 'bubble', // bubble, selection, insertion, binary, stack, queue
    array: [],
    arraySize: 25,
    speed: 500,
    isPlaying: false,
    generator: null,     // Generator instance for stepping
    isFinished: false,
    
    // Stack and Queue data
    linearDS: [],
    maxLinearDSSize: 6,
    
    // Target for searching
    searchTarget: null
};

// Complexity Map
const complexityData = {
    bubble: {
        best: "O(n)",
        avg: "O(n²)",
        worst: "O(n²)",
        space: "O(1)",
        code: [
            "for (let i = 0; i < n - 1; i++) {",
            "  for (let j = 0; j < n - i - 1; j++) {",
            "    // Compare adjacent elements",
            "    if (arr[j] > arr[j + 1]) {",
            "      // Swap elements",
            "      swap(arr, j, j + 1);",
            "    }",
            "  }",
            "}"
        ]
    },
    selection: {
        best: "O(n²)",
        avg: "O(n²)",
        worst: "O(n²)",
        space: "O(1)",
        code: [
            "for (let i = 0; i < n - 1; i++) {",
            "  let min_idx = i;",
            "  for (let j = i + 1; j < n; j++) {",
            "    // Find minimum element index",
            "    if (arr[j] < arr[min_idx]) min_idx = j;",
            "  }",
            "  // Swap minimum element with current position",
            "  swap(arr, i, min_idx);",
            "}"
        ]
    },
    insertion: {
        best: "O(n)",
        avg: "O(n²)",
        worst: "O(n²)",
        space: "O(1)",
        code: [
            "for (let i = 1; i < n; i++) {",
            "  let key = arr[i];",
            "  let j = i - 1;",
            "  // Shift elements greater than key",
            "  while (j >= 0 && arr[j] > key) {",
            "    arr[j + 1] = arr[j];",
            "    j--;",
            "  }",
            "  // Place key in correct position",
            "  arr[j + 1] = key;",
            "}"
        ]
    },
    binary: {
        best: "O(1)",
        avg: "O(log n)",
        worst: "O(log n)",
        space: "O(1)",
        code: [
            "let low = 0, high = n - 1;",
            "while (low <= high) {",
            "  let mid = Math.floor((low + high) / 2);",
            "  if (arr[mid] === target) {",
            "    return mid; // Element found",
            "  } else if (arr[mid] < target) {",
            "    low = mid + 1; // Discard left half",
            "  } else {",
            "    high = mid - 1; // Discard right half",
            "  }",
            "}",
            "return -1; // Element not found"
        ]
    },
    stack: {
        best: "O(1)",
        avg: "O(1)",
        worst: "O(1)",
        space: "O(n)",
        code: [
            "class Stack {",
            "  push(element) {",
            "    // Insert element at top",
            "    this.items.push(element);",
            "  }",
            "  pop() {",
            "    // Remove element from top",
            "    if (this.isEmpty()) return 'Underflow';",
            "    return this.items.pop();",
            "  }",
            "}"
        ]
    },
    queue: {
        best: "O(1)",
        avg: "O(1)",
        worst: "O(1)",
        space: "O(n)",
        code: [
            "class Queue {",
            "  enqueue(element) {",
            "    // Insert element at rear",
            "    this.items.push(element);",
            "  }",
            "  dequeue() {",
            "    // Remove element from front",
            "    if (this.isEmpty()) return 'Underflow';",
            "    return this.items.shift();",
            "  }",
            "}"
        ]
    }
};

// Initialize app on load
window.addEventListener('DOMContentLoaded', () => {
    switchCategory('sorting');
});

// Category tab switching
function switchCategory(category) {
    state.category = category;
    state.isPlaying = false;
    state.generator = null;
    state.isFinished = false;
    
    // Toggle play/pause UI state
    updatePlayPauseButton();
    
    // Toggle navigation tab active class
    document.querySelectorAll('.nav-tab').forEach(tab => {
        tab.classList.remove('active');
    });
    document.getElementById(`tab-${category}`).classList.add('active');

    // Toggle specific controls based on category
    const arrayControls = document.getElementById('array-controls');
    const dsControls = document.getElementById('ds-controls');
    const algorithmSelect = document.getElementById('algorithm-select');

    // Populate algorithm select
    algorithmSelect.innerHTML = '';
    
    if (category === 'sorting') {
        arrayControls.classList.remove('hidden');
        dsControls.classList.add('hidden');
        
        algorithmSelect.innerHTML = `
            <option value="bubble">Bubble Sort</option>
            <option value="selection">Selection Sort</option>
            <option value="insertion">Insertion Sort</option>
        `;
        state.algorithm = 'bubble';
        generateNewData();
    } else if (category === 'searching') {
        arrayControls.classList.remove('hidden');
        dsControls.classList.add('hidden');
        
        algorithmSelect.innerHTML = `
            <option value="binary">Binary Search</option>
        `;
        state.algorithm = 'binary';
        generateNewData();
    } else if (category === 'stack') {
        arrayControls.classList.add('hidden');
        dsControls.classList.remove('hidden');
        
        algorithmSelect.innerHTML = `
            <option value="stack">Stack Visualizer</option>
        `;
        state.algorithm = 'stack';
        state.linearDS = [15, 28, 42]; // Default initial values
        renderLinearDS();
        updateInfoPanel();
    } else if (category === 'queue') {
        arrayControls.classList.add('hidden');
        dsControls.classList.remove('hidden');
        
        algorithmSelect.innerHTML = `
            <option value="queue">Queue Visualizer</option>
        `;
        state.algorithm = 'queue';
        state.linearDS = [15, 28, 42]; // Default initial values
        renderLinearDS();
        updateInfoPanel();
    }

    updateInfoPanel();
}

// Handle Select Algorithm Dropdown change
function onAlgorithmChange() {
    state.algorithm = document.getElementById('algorithm-select').value;
    state.isPlaying = false;
    state.generator = null;
    state.isFinished = false;
    updatePlayPauseButton();
    
    if (state.category === 'sorting' || state.category === 'searching') {
        generateNewData();
    } else {
        renderLinearDS();
    }
    updateInfoPanel();
}

// Generate New Data based on current mode
function generateNewData() {
    state.isPlaying = false;
    state.generator = null;
    state.isFinished = false;
    updatePlayPauseButton();

    const canvas = document.getElementById('visualizer-canvas');
    canvas.innerHTML = '';

    if (state.category === 'sorting') {
        state.array = [];
        for (let i = 0; i < state.arraySize; i++) {
            state.array.push(Math.floor(Math.random() * 85) + 15); // values 15 to 100
        }
        renderBars();
    } else if (state.category === 'searching') {
        state.array = [];
        for (let i = 0; i < state.arraySize; i++) {
            state.array.push(Math.floor(Math.random() * 85) + 15);
        }
        state.array.sort((a, b) => a - b);
        
        // Pick random element as the target
        const randIdx = Math.floor(Math.random() * state.arraySize);
        state.searchTarget = state.array[randIdx];
        
        renderBars();
        
        // Append visual target note
        const statusText = document.getElementById('status-text');
        statusText.innerHTML = `Generated sorted array. We want to find target element <strong class="text-glow">${state.searchTarget}</strong>.`;
    }
    
    // Clear pointers
    removePointers();
    updateInfoPanel();
}

// Prompt for custom comma-separated values
function promptCustomInput() {
    const input = prompt("Enter a comma-separated list of numbers (between 10 and 100, max 30 elements):", "40,12,65,80,23,55,90,5");
    if (input) {
        const nums = input.split(',')
            .map(num => parseInt(num.trim(), 10))
            .filter(num => !isNaN(num) && num >= 5 && num <= 100);
            
        if (nums.length > 0) {
            state.isPlaying = false;
            state.generator = null;
            state.isFinished = false;
            updatePlayPauseButton();
            
            state.arraySize = Math.min(nums.length, 30);
            document.getElementById('array-size-slider').value = state.arraySize;
            document.getElementById('array-size-val').textContent = state.arraySize;
            
            state.array = nums.slice(0, 30);
            if (state.category === 'searching') {
                state.array.sort((a, b) => a - b);
                const randIdx = Math.floor(Math.random() * state.array.length);
                state.searchTarget = state.array[randIdx];
            }
            
            renderBars();
            removePointers();
            
            if (state.category === 'searching') {
                document.getElementById('status-text').innerHTML = `Custom sorted array created. Find target <strong class="text-glow">${state.searchTarget}</strong>.`;
            } else {
                document.getElementById('status-text').textContent = "Custom array loaded. Ready to start.";
            }
        } else {
            alert("Invalid input! Please insert valid numbers between 5 and 100.");
        }
    }
}

// Render values as vertical bars
function renderBars() {
    const canvas = document.getElementById('visualizer-canvas');
    canvas.innerHTML = '';
    
    state.array.forEach((val, idx) => {
        const bar = document.createElement('div');
        bar.classList.add('visual-bar');
        bar.id = `bar-${idx}`;
        bar.style.height = `${val}%`;
        
        // Dynamic scaling of widths based on length
        const totalGap = (state.arraySize - 1) * 4;
        bar.style.width = `calc((100% - ${totalGap}px) / ${state.arraySize})`;
        
        // Show values inside/below bars if sizes are readable
        if (state.arraySize <= 25) {
            const barValue = document.createElement('span');
            barValue.classList.add('visual-bar-value');
            barValue.textContent = val;
            bar.appendChild(barValue);
        }
        
        canvas.appendChild(bar);
    });
}

// Render Stack or Queue
function renderLinearDS() {
    const canvas = document.getElementById('visualizer-canvas');
    canvas.innerHTML = '';

    const container = document.createElement('div');
    container.classList.add('ds-container');

    const dsWrapper = document.createElement('div');
    if (state.category === 'stack') {
        dsWrapper.classList.add('stack-canvas');
    } else {
        dsWrapper.classList.add('queue-canvas');
    }

    state.linearDS.forEach((val, index) => {
        const node = document.createElement('div');
        node.classList.add('ds-node');
        node.textContent = val;
        node.id = `node-${index}`;
        
        // Label front and rear for Queue, or top for Stack
        if (state.category === 'queue') {
            if (index === 0) {
                node.style.border = "2px solid #ef4444"; // Front node highlighting
                node.title = "Front of Queue";
            }
            if (index === state.linearDS.length - 1) {
                node.style.boxShadow = "0 0 12px var(--accent-violet-glow)";
                node.title = "Rear of Queue";
            }
        } else if (state.category === 'stack') {
            if (index === state.linearDS.length - 1) {
                node.style.border = "2px solid #ef4444"; // Top node highlighting
                node.title = "Top of Stack";
            }
        }
        
        dsWrapper.appendChild(node);
    });

    container.appendChild(dsWrapper);
    canvas.appendChild(container);
}

// Stack / Queue Input and Action trigger
function executeDSAction(action) {
    const inputVal = document.getElementById('ds-input');
    const val = parseInt(inputVal.value, 10);
    
    if (action === 'push') {
        if (isNaN(val) || val < 1 || val > 99) {
            alert("Please enter a valid node integer (1 - 99)");
            return;
        }
        
        if (state.linearDS.length >= state.maxLinearDSSize) {
            alert(`Overflow Warning! Max capacity is ${state.maxLinearDSSize} elements.`);
            return;
        }
        
        state.linearDS.push(val);
        inputVal.value = '';
        renderLinearDS();
        
        document.getElementById('status-text').innerHTML = `Pushed value <strong class="text-glow">${val}</strong> onto the top of the stack.`;
    } else if (action === 'pop') {
        if (state.linearDS.length === 0) {
            alert("Underflow Warning! Structure is already empty.");
            return;
        }
        
        // Animation trigger
        const topNodeIndex = state.category === 'stack' ? state.linearDS.length - 1 : 0;
        const targetNode = document.getElementById(`node-${topNodeIndex}`);
        
        if (targetNode) {
            targetNode.classList.add(state.category === 'stack' ? 'state-pop' : 'state-dequeue');
            
            // Wait for keyframe animation to complete before re-rendering
            setTimeout(() => {
                const popped = state.category === 'stack' ? state.linearDS.pop() : state.linearDS.shift();
                renderLinearDS();
                document.getElementById('status-text').innerHTML = `${state.category === 'stack' ? 'Popped' : 'Dequeued'} value <strong class="text-glow">${popped}</strong> from the ${state.category === 'stack' ? 'top' : 'front'}.`;
            }, 300);
        }
    }
}

// Play / Pause Toggle
function togglePlayPause() {
    if (state.category === 'stack' || state.category === 'queue') return;

    if (state.isFinished) {
        generateNewData();
    }

    state.isPlaying = !state.isPlaying;
    updatePlayPauseButton();

    if (state.isPlaying) {
        runSimulationLoop();
    }
}

// Run loop of active simulation
async function runSimulationLoop() {
    if (!state.generator) {
        state.generator = getAlgorithmGenerator();
    }

    while (state.isPlaying && !state.isFinished) {
        const step = state.generator.next();
        if (step.done) {
            state.isPlaying = false;
            state.isFinished = true;
            updatePlayPauseButton();
            break;
        }
        
        updateUIForStep(step.value);
        await delay(state.speed);
    }
}

// Manual single step forward
function stepForward() {
    if (state.category === 'stack' || state.category === 'queue') return;

    if (state.isFinished) {
        generateNewData();
    }

    if (!state.generator) {
        state.generator = getAlgorithmGenerator();
    }

    state.isPlaying = false;
    updatePlayPauseButton();

    const step = state.generator.next();
    if (step.done) {
        state.isFinished = true;
        document.getElementById('status-text').innerHTML = "Algorithm successfully completed.";
    } else {
        updateUIForStep(step.value);
    }
}

// Reset visualizer and simulation
function resetSimulation() {
    if (state.category === 'sorting' || state.category === 'searching') {
        generateNewData();
    } else {
        state.linearDS = [15, 28, 42];
        renderLinearDS();
        document.getElementById('status-text').textContent = "Structure reset to default initial state.";
    }
}

// Helpers for sliders updates
function onSizeChange(size) {
    state.arraySize = parseInt(size, 10);
    document.getElementById('array-size-val').textContent = size;
    generateNewData();
}

function onSpeedChange(ms) {
    state.speed = parseInt(ms, 10);
    document.getElementById('speed-val').textContent = `${ms}ms`;
}

// Update Play/Pause SVG layout
function updatePlayPauseButton() {
    const playIcon = document.getElementById('play-icon');
    const pauseIcon = document.getElementById('pause-icon');
    
    if (state.isPlaying) {
        playIcon.classList.add('hidden');
        pauseIcon.classList.remove('hidden');
    } else {
        playIcon.classList.remove('hidden');
        pauseIcon.classList.add('hidden');
    }
}

// Generate the specific execution generator object
function getAlgorithmGenerator() {
    if (state.algorithm === 'bubble') {
        return bubbleSortGenerator([...state.array]);
    } else if (state.algorithm === 'selection') {
        return selectionSortGenerator([...state.array]);
    } else if (state.algorithm === 'insertion') {
        return insertionSortGenerator([...state.array]);
    } else if (state.algorithm === 'binary') {
        return binarySearchGenerator([...state.array], state.searchTarget);
    }
    return null;
}

// Update DOM elements on yielded step events
function updateUIForStep(step) {
    // 1. Text Status Explanation
    document.getElementById('status-text').innerHTML = step.description;

    // 2. Highlighting Line of Code
    highlightCodeLine(step.codeLine);

    // 3. Modifying classes of bars
    if (state.category === 'sorting') {
        // Redraw heights based on current array state if sorted / swapped
        if (step.array) {
            state.array = step.array;
            renderBars();
        }
        
        // Remove old states
        document.querySelectorAll('.visual-bar').forEach(bar => {
            bar.classList.remove('state-compare', 'state-active', 'state-success');
        });

        // Set state colors
        if (step.type === 'compare') {
            step.indices.forEach(idx => {
                document.getElementById(`bar-${idx}`)?.classList.add('state-compare');
            });
        } else if (step.type === 'swap') {
            step.indices.forEach(idx => {
                document.getElementById(`bar-${idx}`)?.classList.add('state-active');
            });
        } else if (step.type === 'sorted-step') {
            document.getElementById(`bar-${step.index}`)?.classList.add('state-success');
        } else if (step.type === 'all-sorted') {
            document.querySelectorAll('.visual-bar').forEach(bar => {
                bar.classList.add('state-success');
            });
        }
    } else if (state.category === 'searching') {
        // Redraw search layout
        document.querySelectorAll('.visual-bar').forEach(bar => {
            bar.classList.remove('state-compare', 'state-active', 'state-success', 'state-discarded');
        });

        // Highlight discarded ranges
        if (step.low !== undefined && step.high !== undefined) {
            for (let i = 0; i < state.array.length; i++) {
                if (i < step.low || i > step.high) {
                    document.getElementById(`bar-${i}`)?.classList.add('state-discarded');
                }
            }
        }

        // Apply pointers
        updateSearchPointers(step.low, step.mid, step.high);

        if (step.type === 'mid-check') {
            document.getElementById(`bar-${step.mid}`)?.classList.add('state-compare');
        } else if (step.type === 'found') {
            document.getElementById(`bar-${step.mid}`)?.classList.add('state-success');
        }
    }
}

// Manage searching pointers (low, mid, high label positioning)
function updateSearchPointers(low, mid, high) {
    removePointers();
    const canvas = document.getElementById('visualizer-canvas');
    
    if (low !== undefined && low !== null) {
        createPointerTag(low, 'Low', 'pointer-low');
    }
    if (mid !== undefined && mid !== null) {
        createPointerTag(mid, 'Mid', 'pointer-mid');
    }
    if (high !== undefined && high !== null) {
        createPointerTag(high, 'High', 'pointer-high');
    }
}

function createPointerTag(index, label, className) {
    const bar = document.getElementById(`bar-${index}`);
    if (!bar) return;
    
    const marker = document.createElement('div');
    marker.classList.add('pointer-marker', className);
    marker.textContent = label;
    
    // Position tag absolute relative to bar offset
    const barRect = bar.offsetLeft + (bar.offsetWidth / 2);
    marker.style.left = `${barRect}px`;
    
    document.getElementById('visualizer-canvas').appendChild(marker);
}

function removePointers() {
    document.querySelectorAll('.pointer-marker').forEach(el => el.remove());
}

// Highlight editor code line (1-indexed based on block array)
function highlightCodeLine(lineIdx) {
    document.querySelectorAll('.code-line').forEach(el => {
        el.classList.remove('code-highlight');
    });
    if (lineIdx !== undefined && lineIdx !== null) {
        const lineElement = document.getElementById(`line-${lineIdx}`);
        if (lineElement) {
            lineElement.classList.add('code-highlight');
        }
    }
}

// Update Details Card (Complexity values & Code syntax template)
function updateInfoPanel() {
    const currentAlgo = state.algorithm;
    const details = complexityData[currentAlgo];

    if (!details) return;

    // Time / Space updates
    document.getElementById('time-best').textContent = details.best;
    document.getElementById('time-avg').textContent = details.avg;
    document.getElementById('time-worst').textContent = details.worst;
    document.getElementById('space-complexity').textContent = details.space;

    // Code template display
    const codeSnippet = document.getElementById('code-snippet');
    codeSnippet.innerHTML = '';
    
    details.code.forEach((line, idx) => {
        const span = document.createElement('span');
        span.classList.add('code-line');
        span.id = `line-${idx}`;
        
        // Simple regex check to gray out comments
        if (line.trim().startsWith('//')) {
            span.classList.add('code-comment');
        }
        
        span.textContent = line;
        codeSnippet.appendChild(span);
    });
}

// Switch Detail / Pseudocode tabs
function switchInfoTab(tab) {
    const detailsBtn = document.getElementById('info-tab-details');
    const codeBtn = document.getElementById('info-tab-code');
    const detailsContent = document.getElementById('info-content-details');
    const codeContent = document.getElementById('info-content-code');

    if (tab === 'details') {
        detailsBtn.classList.add('active');
        codeBtn.classList.remove('active');
        detailsContent.classList.remove('hidden');
        codeContent.classList.add('hidden');
    } else {
        detailsBtn.classList.remove('active');
        codeBtn.classList.add('active');
        detailsContent.classList.add('hidden');
        codeContent.classList.remove('hidden');
    }
}

// Utility Delay Promise
const delay = (ms) => new Promise(resolve => setTimeout(resolve, ms));


/*
================================================================
   ALGORITHM GENERATOR IMPLEMENTATIONS (YIELDING PHASES)
================================================================
*/

// 1. Bubble Sort Generator
function* bubbleSortGenerator(arr) {
    let n = arr.length;
    let swapped;
    for (let i = 0; i < n - 1; i++) {
        swapped = false;
        yield { 
            type: 'step', 
            codeLine: 0, 
            description: `Starting Pass ${i + 1}. Outer loop range: 0 to ${n - i - 2}.` 
        };
        
        for (let j = 0; j < n - i - 1; j++) {
            yield { 
                type: 'compare', 
                indices: [j, j + 1], 
                codeLine: 3, 
                description: `Comparing elements at indices ${j} (${arr[j]}) and ${j+1} (${arr[j+1]}).` 
            };
            
            if (arr[j] > arr[j + 1]) {
                let temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
                
                yield { 
                    type: 'swap', 
                    indices: [j, j + 1], 
                    array: [...arr], 
                    codeLine: 5, 
                    description: `Swapped indices ${j} and ${j+1} because ${temp} > ${arr[j]}.` 
                };
            }
        }
        
        yield { 
            type: 'sorted-step', 
            index: n - i - 1, 
            codeLine: 8, 
            description: `Index ${n - i - 1} (${arr[n - i - 1]}) is placed in its final sorted position.` 
        };

        if (!swapped) {
            yield {
                type: 'step',
                codeLine: 8,
                description: `No swaps occurred in this pass. Array is fully sorted!`
            };
            break;
        }
    }
    
    yield { 
        type: 'all-sorted', 
        array: [...arr], 
        codeLine: 8, 
        description: "Bubble Sort Completed. The entire array is sorted!" 
    };
}

// 2. Selection Sort Generator
function* selectionSortGenerator(arr) {
    let n = arr.length;
    for (let i = 0; i < n - 1; i++) {
        let minIdx = i;
        yield { 
            type: 'step', 
            codeLine: 1, 
            description: `Assuming index ${i} (${arr[i]}) holds the minimum value.` 
        };
        
        for (let j = i + 1; j < n; j++) {
            yield { 
                type: 'compare', 
                indices: [minIdx, j], 
                codeLine: 3, 
                description: `Scanning: comparing index ${j} (${arr[j]}) with current minimum at ${minIdx} (${arr[minIdx]}).` 
            };
            
            if (arr[j] < arr[minIdx]) {
                minIdx = j;
                yield { 
                    type: 'compare', 
                    indices: [minIdx], 
                    codeLine: 4, 
                    description: `New minimum element found at index ${minIdx} (${arr[minIdx]}).` 
                };
            }
        }
        
        if (minIdx !== i) {
            let temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
            yield { 
                type: 'swap', 
                indices: [i, minIdx], 
                array: [...arr], 
                codeLine: 7, 
                description: `Swapped index ${i} (${temp}) with minimum index ${minIdx} (${arr[i]}).` 
            };
        } else {
            yield { 
                type: 'step', 
                codeLine: 7, 
                description: `Index ${i} is already the minimum element. No swap needed.` 
            };
        }
        
        yield { 
            type: 'sorted-step', 
            index: i, 
            codeLine: 8, 
            description: `Index ${i} (${arr[i]}) is placed in its final sorted position.` 
        };
    }
    
    yield { 
        type: 'all-sorted', 
        array: [...arr], 
        codeLine: 8, 
        description: "Selection Sort Completed. The entire array is sorted!" 
    };
}

// 3. Insertion Sort Generator
function* insertionSortGenerator(arr) {
    let n = arr.length;
    for (let i = 1; i < n; i++) {
        let key = arr[i];
        let j = i - 1;
        
        yield { 
            type: 'step', 
            codeLine: 1, 
            description: `Selecting insertion key element ${key} at index ${i}.` 
        };
        
        while (j >= 0 && arr[j] > key) {
            yield { 
                type: 'compare', 
                indices: [j, j + 1], 
                codeLine: 4, 
                description: `Comparing index ${j} (${arr[j]}) with key (${key}). It is greater; shifting element right.` 
            };
            
            arr[j + 1] = arr[j];
            j--;
            
            yield { 
                type: 'swap', 
                indices: [j + 2, j + 1], // indices that were shifted
                array: [...arr], 
                codeLine: 5, 
                description: `Shifted element from index ${j+2} to ${j+1}.` 
            };
        }
        
        arr[j + 1] = key;
        yield { 
            type: 'swap', 
            indices: [j + 1], 
            array: [...arr], 
            codeLine: 9, 
            description: `Inserted key element (${key}) at correct sorted partition position index ${j + 1}.` 
        };
    }
    
    yield { 
        type: 'all-sorted', 
        array: [...arr], 
        codeLine: 10, 
        description: "Insertion Sort Completed. The entire array is sorted!" 
    };
}

// 4. Binary Search Generator
function* binarySearchGenerator(arr, target) {
    let low = 0;
    let high = arr.length - 1;
    
    yield { 
        type: 'step', 
        low: low, 
        high: high, 
        codeLine: 0, 
        description: `Starting Binary Search. Low index is ${low}, High index is ${high}.` 
    };
    
    while (low <= high) {
        let mid = Math.floor((low + high) / 2);
        
        yield { 
            type: 'mid-check', 
            low: low, 
            mid: mid, 
            high: high, 
            codeLine: 2, 
            description: `Calculated middle index = Math.floor((${low} + ${high}) / 2) = ${mid}.` 
        };
        
        yield { 
            type: 'mid-check', 
            low: low, 
            mid: mid, 
            high: high, 
            codeLine: 3, 
            description: `Comparing middle value at index ${mid} (${arr[mid]}) with target value ${target}.` 
        };
        
        if (arr[mid] === target) {
            yield { 
                type: 'found', 
                low: low, 
                mid: mid, 
                high: high, 
                codeLine: 4, 
                description: `Target element ${target} found at middle index ${mid}!` 
            };
            return;
        } else if (arr[mid] < target) {
            let prevLow = low;
            low = mid + 1;
            yield { 
                type: 'step', 
                low: low, 
                high: high, 
                codeLine: 6, 
                description: `Since middle value ${arr[mid]} < target ${target}, discarding the left half. Moving low pointer to ${low}.` 
            };
        } else {
            let prevHigh = high;
            high = mid - 1;
            yield { 
                type: 'step', 
                low: low, 
                high: high, 
                codeLine: 8, 
                description: `Since middle value ${arr[mid]} > target ${target}, discarding the right half. Moving high pointer to ${high}.` 
            };
        }
    }
    
    yield { 
        type: 'not-found', 
        codeLine: 11, 
        description: `Search completed. Low (${low}) exceeded High (${high}). Target element ${target} is not in the array.` 
    };
}
